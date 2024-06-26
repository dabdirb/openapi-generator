/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.yaml;

import io.swagger.v3.oas.models.OpenAPI;
import org.openapitools.codegen.ClientOptInput;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.TestUtils;
import org.openapitools.codegen.config.CodegenConfigurator;
import org.openapitools.codegen.languages.OpenAPIYamlGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlGeneratorTest {

    @Test
    public void testGeneratePing() throws Exception {
        Map<String, Object> properties = new HashMap<>();

        File output = Files.createTempDirectory("test").toFile();

        final CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName("openapi-yaml")
                .setAdditionalProperties(properties)
                .setInputSpec("src/test/resources/3_0/ping.yaml")
                .setOutputDir(output.getAbsolutePath().replace("\\", "/"));

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        List<File> files = generator.opts(clientOptInput).generate();
        Assert.assertEquals(files.size(), 5);
        TestUtils.ensureContainsFile(files, output, "openapi/openapi.yaml");
        TestUtils.ensureContainsFile(files, output, "README.md");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator-ignore");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator/FILES");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator/VERSION");

        output.deleteOnExit();
    }


    @Test
    public void testGeneratePingOtherOutputFile() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(OpenAPIYamlGenerator.OUTPUT_NAME, "ping.yaml");

        File output = Files.createTempDirectory("test").toFile();

        final CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName("openapi-yaml")
                .setAdditionalProperties(properties)
                .setInputSpec("src/test/resources/3_0/ping.yaml")
                .setOutputDir(output.getAbsolutePath().replace("\\", "/"));

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        List<File> files = generator.opts(clientOptInput).generate();

        Assert.assertEquals(files.size(), 5);
        TestUtils.ensureContainsFile(files, output, "ping.yaml");
        TestUtils.ensureContainsFile(files, output, "README.md");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator-ignore");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator/FILES");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator/VERSION");

        output.deleteOnExit();
    }

    @Test
    public void testIssue9086() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(OpenAPIYamlGenerator.OUTPUT_NAME, "issue_9086.yaml");

        File output = Files.createTempDirectory("issue_9086").toFile();
        output.deleteOnExit();

        final CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName("openapi-yaml")
                .setAdditionalProperties(properties)
                .setInputSpec("src/test/resources/2_0/issue_9086.yaml")
                .setOutputDir(output.getAbsolutePath().replace("\\", "/"));

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        List<File> files = generator.opts(clientOptInput).generate();
        Assert.assertEquals(files.size(), 5);
        TestUtils.ensureContainsFile(files, output, "issue_9086.yaml");

        TestUtils.ensureContainsFile(files, output, "README.md");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator-ignore");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator/FILES");
        TestUtils.ensureContainsFile(files, output, ".openapi-generator/VERSION");

        OpenAPI actual = TestUtils.parseSpec("src/test/resources/2_0/issue_9086.yaml");
        OpenAPI expected = TestUtils.parseSpec("src/test/resources/2_0/issue_9086_expected.yaml");

        // use #toString because the equals methods is a little stricter than necessary for this test
        Assert.assertEquals(actual.getComponents().getSchemas().get("bar2").getAdditionalProperties(),
                expected.getComponents().getSchemas().get("bar2").getAdditionalProperties());
        Assert.assertEquals(actual.getPaths().get("/foo/bar").getPost().getResponses().get("200").getContent().get("*/*").getSchema().getAdditionalProperties(),
                expected.getComponents().getSchemas().get("_foo_bar_post_200_response").getAdditionalProperties());
    }

    @Test
    public void testIssue18622() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(OpenAPIYamlGenerator.OUTPUT_NAME, "issue_18622.yaml");

        File output = Files.createTempDirectory("issue_18622").toFile();
        output.deleteOnExit();

        final CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName("openapi-yaml")
                .setAdditionalProperties(properties)
                .setInputSpec("src/test/resources/2_0/issue_18622.yaml")
                .setOutputDir(output.getAbsolutePath().replace("\\", "/"));

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        List<File> files = generator.opts(clientOptInput).generate();
        Assert.assertEquals(files.size(), 5);
        TestUtils.ensureContainsFile(files, output, "issue_18622.yaml");

        OpenAPI expected = TestUtils.parseSpec("src/test/resources/2_0/issue_18622_expected.yaml");
        OpenAPI actual = TestUtils.parseSpec(Path.of(output.getAbsolutePath(), "issue_18622.yaml").toString());

        Assert.assertEquals(actual.getComponents().getSchemas().get("myresponse").getExample(),
                expected.getComponents().getSchemas().get("myresponse").getExample());
    }
}
