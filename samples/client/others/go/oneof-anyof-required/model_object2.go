/*
Test

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)

API version: 1.0.0
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"encoding/json"
	"fmt"
)


// Object2 struct for Object2
type Object2 struct {
	NestedObject1 *NestedObject1
	NestedObject2 *NestedObject2
}

// Unmarshal JSON data into any of the pointers in the struct
func (dst *Object2) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal JSON data into NestedObject1
	err = json.Unmarshal(data, &dst.NestedObject1);
	if err == nil {
		jsonNestedObject1, _ := json.Marshal(dst.NestedObject1)
		if string(jsonNestedObject1) == "{}" { // empty struct
			dst.NestedObject1 = nil
		} else {
			return nil // data stored in dst.NestedObject1, return on the first match
		}
	} else {
		dst.NestedObject1 = nil
	}

	// try to unmarshal JSON data into NestedObject2
	err = json.Unmarshal(data, &dst.NestedObject2);
	if err == nil {
		jsonNestedObject2, _ := json.Marshal(dst.NestedObject2)
		if string(jsonNestedObject2) == "{}" { // empty struct
			dst.NestedObject2 = nil
		} else {
			return nil // data stored in dst.NestedObject2, return on the first match
		}
	} else {
		dst.NestedObject2 = nil
	}

	return fmt.Errorf("data failed to match schemas in anyOf(Object2)")
}

// Marshal data from the first non-nil pointers in the struct to JSON
func (src Object2) MarshalJSON() ([]byte, error) {
	if src.NestedObject1 != nil {
		return json.Marshal(&src.NestedObject1)
	}

	if src.NestedObject2 != nil {
		return json.Marshal(&src.NestedObject2)
	}

	return nil, nil // no data in anyOf schemas
}


type NullableObject2 struct {
	value *Object2
	isSet bool
}

func (v NullableObject2) Get() *Object2 {
	return v.value
}

func (v *NullableObject2) Set(val *Object2) {
	v.value = val
	v.isSet = true
}

func (v NullableObject2) IsSet() bool {
	return v.isSet
}

func (v *NullableObject2) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableObject2(val *Object2) *NullableObject2 {
	return &NullableObject2{value: val, isSet: true}
}

func (v NullableObject2) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableObject2) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


