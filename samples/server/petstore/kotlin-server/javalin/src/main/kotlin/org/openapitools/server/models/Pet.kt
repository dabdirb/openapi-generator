/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package org.openapitools.server.models

import org.openapitools.server.models.Category
import org.openapitools.server.models.Tag

/**
 * A pet for sale in the pet store
 * @param name 
 * @param photoUrls 
 * @param id 
 * @param category 
 * @param tags 
 * @param status pet status in the store
 */
data class Pet(
    
    @field:com.fasterxml.jackson.annotation.JsonProperty("name")
    val name: kotlin.String,
    
    @field:com.fasterxml.jackson.annotation.JsonProperty("photoUrls")
    val photoUrls: kotlin.collections.List<kotlin.String>,
    
    @field:com.fasterxml.jackson.annotation.JsonProperty("id")
    val id: kotlin.Long? = null,
    
    @field:com.fasterxml.jackson.annotation.JsonProperty("category")
    val category: Category? = null,
    
    @field:com.fasterxml.jackson.annotation.JsonProperty("tags")
    val tags: kotlin.collections.List<Tag>? = null,
    /* pet status in the store */
    
    @field:com.fasterxml.jackson.annotation.JsonProperty("status")
    val status: Pet.Status? = null
)
{
    /**
    * pet status in the store
    * Values: available,pending,sold
    */
    enum class Status(val value: kotlin.String){
        available("available"),
        pending("pending"),
        sold("sold");
    }
}

