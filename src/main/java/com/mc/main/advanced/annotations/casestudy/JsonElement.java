package com.mc.main.advanced.annotations.casestudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Here we have a annotation that marks a Field, this gives us the ability to provide some meta
// data around the field in question.
//
// When we build up a Json object, we divide the object members into a "key-values" model.
// in this annotation we can declare that this annotation can store and allow the allocation
// of a key String value in the form of a method with the respective type return value.
//
// we can also use default as a means to provide a default value not provided!
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonElement {
	public String key() default "";
}
