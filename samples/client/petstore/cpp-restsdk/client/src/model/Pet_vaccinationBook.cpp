/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 *
 * NOTE: This class is auto generated by OpenAPI-Generator 7.6.0-SNAPSHOT.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */



#include "CppRestPetstoreClient/model/Pet_vaccinationBook.h"

namespace org {
namespace openapitools {
namespace client {
namespace model {



Pet_vaccinationBook::Pet_vaccinationBook()
{
    m_VaccinesIsSet = false;
}

Pet_vaccinationBook::~Pet_vaccinationBook()
{
}

void Pet_vaccinationBook::validate()
{
    // TODO: implement validation
}

web::json::value Pet_vaccinationBook::toJson() const
{

    web::json::value val = web::json::value::object();
    
    if(m_VaccinesIsSet)
    {
        val[utility::conversions::to_string_t(U("vaccines"))] = ModelBase::toJson(m_Vaccines);
    }

    return val;
}

bool Pet_vaccinationBook::fromJson(const web::json::value& val)
{
    bool ok = true;
    
    if(val.has_field(utility::conversions::to_string_t(U("vaccines"))))
    {
        const web::json::value& fieldValue = val.at(utility::conversions::to_string_t(U("vaccines")));
        if(!fieldValue.is_null())
        {
            std::set<std::shared_ptr<Vaccine>> refVal_setVaccines;
            ok &= ModelBase::fromJson(fieldValue, refVal_setVaccines);
            setVaccines(refVal_setVaccines);
        }
    }
    return ok;
}

void Pet_vaccinationBook::toMultipart(std::shared_ptr<MultipartFormData> multipart, const utility::string_t& prefix) const
{
    utility::string_t namePrefix = prefix;
    if(namePrefix.size() > 0 && namePrefix.substr(namePrefix.size() - 1) != utility::conversions::to_string_t(U(".")))
    {
        namePrefix += utility::conversions::to_string_t(U("."));
    }
    if(m_VaccinesIsSet)
    {
        multipart->add(ModelBase::toHttpContent(namePrefix + utility::conversions::to_string_t(U("vaccines")), m_Vaccines));
    }
}

bool Pet_vaccinationBook::fromMultiPart(std::shared_ptr<MultipartFormData> multipart, const utility::string_t& prefix)
{
    bool ok = true;
    utility::string_t namePrefix = prefix;
    if(namePrefix.size() > 0 && namePrefix.substr(namePrefix.size() - 1) != utility::conversions::to_string_t(U(".")))
    {
        namePrefix += utility::conversions::to_string_t(U("."));
    }

    if(multipart->hasContent(utility::conversions::to_string_t(U("vaccines"))))
    {
        std::set<std::shared_ptr<Vaccine>> refVal_setVaccines;
        ok &= ModelBase::fromHttpContent(multipart->getContent(utility::conversions::to_string_t(U("vaccines"))), refVal_setVaccines );
        setVaccines(refVal_setVaccines);
    }
    return ok;
}

std::set<std::shared_ptr<Vaccine>>& Pet_vaccinationBook::getVaccines()
{
    return m_Vaccines;
}

void Pet_vaccinationBook::setVaccines(const std::set<std::shared_ptr<Vaccine>>& value)
{
    m_Vaccines = value;
    m_VaccinesIsSet = true;
}

bool Pet_vaccinationBook::vaccinesIsSet() const
{
    return m_VaccinesIsSet;
}

void Pet_vaccinationBook::unsetVaccines()
{
    m_VaccinesIsSet = false;
}
}
}
}
}


