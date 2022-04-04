package com.mc.main.advanced.annotations.casestudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Much like the Init Annotation, the idea here is to mark a TYPE - or Class for
// reference by code; it has implications about how a class and its implied capabilities.
//
// In this case, we are suggesting that this marked class is setup to be annotated to provide a clear
// potential for translating its class members to a JSON object
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JsonSerializable {}
