package com.mc.main.advanced.annotations.casestudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This will allow us to place a flag on a method, code might use reflection
// to identify that this method is marked to infer some kind of initialisation feature.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {}
