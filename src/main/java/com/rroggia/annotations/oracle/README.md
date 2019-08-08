# Oracle Tutorial

## What is an annotation?
An annotations is a form of metadata, that provides data about a program that is not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.

Annotations have a number of uses, among them:

* **Information for the compiler** — Annotations can be used by the compiler to detect errors or suppress warnings.
* **Compile-time and deployment-time processing** — Software tools can process annotation information to generate code, XML files, and so forth.
* **Runtime processing** — Some annotations are available to be examined at runtime.

## Basics

### The format of an Annotation
In its simplest format it looks like `@Entity`.

The (@) indicates to the compiler that what follows is an annotation. In the example above, `Entity` is the name of the annotation.

An annotation can have elements, which can be named or unnamed and there are values for those elements:

```java 
@Author(
	name = "Benjamin Franklin",
	date = "3/27/2003"
}
class MyClass{...}
```

If the annotation has only one element named `value`, then the element can be omitted, for example: `@SuppressWarnings(value = "unchecked")` can be reduced to `@SuppressWarnings("unchecked")`. If, there is no element in the annotation, you can also omit the parenthesis, for example the `@Entity` annotation above is reduced from `@Entity()`.

It is possible to have multiple annotations on the same declaration.

```java
@Author
@Ebook
class MyClass{...}
```

If the annotation have the same type, then it is called a repeating annotation.

```java
@Author(name = "Jane Doe")
@Author(name = "John Smith")
class MyClass { ... }
```

The annotation type can be one of the types that are defined in the `java.lang` or `java.lang.annotation`. Or It's also possible to create your own custom annotation type.
* Annotation Types Summary at the bottom of [java.lang javadoc](https://docs.oracle.com/javase/8/docs/api/java/lang/package-summary.html).
* Annotation Types Summary at the bottom of [java.lang.annotations javadoc](https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/package-summary.html)

### Where annotations can be used
Annotations can be applied to declarations: declarations of classes, fields, methods, and other program elements. When used on a declaration, each annotation often appears, by convention, on its own line.

Annotations can also be applied to use of types, they are called `type annotation`:
* Class instance creation: `new @Internal MyObject()`
* Type cast: `String myString = (@NonNull String) str;`
* `implements` clause: `class UnmodifiableList<T> implements @Readonly List<@Readonly T> { ... }`
* Thrwon exception declaration: `void monitorTemperature() throws @Critical TemperatureException { ... }` 

## Declaring
The annotation type definition looks similar to an `interface` definition where the keyword `interface` is preceded by `@`. Annotation types are a form of `interface`. The body of the previous annotation definition contains *annotation type element* declarations, which look a lot like methods. Note that they can define optional `default` values.

Note: To make the information in `@ClassPreamble` appear in Javadoc-generated documentation, you must annotate the `@ClassPreamble` definition with the `@Documented` annotation.

## Predefined Annotation Type
Some annotation types are used by the Java compiler, and some apply to other annotations.

### Annotation types used by the Java language

* `@Deprecated` indicates that the marked element is deprecated and should no longer be used. The compiler generates a warning whenever a program uses a method, class, or field with the @Deprecated annotation. When an element is deprecated, it should also be documented using the Javadoc `@deprecated` tag. The use of the at sign (@) in both Javadoc comments and in annotations is not coincidental: they are related conceptually. Also, note that the Javadoc tag starts with a lowercase d and the annotation starts with an uppercase D.

* `@Override` informs the compiler that the element is meant to override an element declared in a superclass. While it is not required to use this annotation when overriding a method, it helps to prevent errors. If a method marked with `@Override` fails to correctly override a method in one of its superclasses, the compiler generates an error.

* `@SuppressWarnings` tells the compiler to suppress specific warnings that it would otherwise generate. 

Every compiler warning belongs to a category. The Java Language Specification lists two categories: *deprecation* and *unchecked*:
1. unchecked warning can occur when interfacing with legacy code written before the advent of generics.
2. deprecation warning occur when a type, method, field, or constructor whose declaration is annotated with `@Deprecated` is used (overridden, invoked, or referenced by name) in a construct which is explicitly or implicitly declared.

* `@SafeVarargs` when applied to a method or constructor, asserts that the code does not perform potentially unsafe operations on its varargs parameter. When this annotation type is used, unchecked warnings relating to varargs usage are suppressed.

* `@FunctionalInterface` indicates that the type declaration is intended to be a functional interface.
 
### Annotations That Apply to Other Annotations
Annotations that apply to other annotations are called *meta-annotations*.

* `@Retention` specifies how the marked annotation is stored:
1. `RetentionPolicy.SOURCE` retained at source level and ignored by compiler. 
2. `RetentionPolicy.CLASS` retained by compiler at compiler time, but ignored by JVM. Default option is none is present.
3. `RetentionPolicy.RUNTIME` retained by JVM so it can be used in runtime.

* `@Documented` indicates that whenever the specified annotation is used those elements should be documented using the Javadoc tool. 

* `@Target` marks another annotation to restrict what kind of Java elements the annotation can be applied to.
1. `ElementType.ANNOTATION_TYPE` can be applied to an annotation type.
2. `ElementType.CONSTRUCTOR` can be applied to a constructor.
3. `ElementType.FIELD` can be applied to a field or property.
4. `ElementType.LOCAL_VARIABLE` can be applied to a local variable.
5. `ElementType.METHOD` can be applied to a method-level annotation.
6. `ElementType.PACKAGE` can be applied to a package declaration.
7. `ElementType.PARAMETER` can be applied to the parameters of a method.
8. `ElementType.TYPE` can be applied to any element of a class.

* `@Inherited`indicates that the annotation type can be inherited from the super class. (False by default.) When the user queries the annotation type and the class has no annotation for this type, the class' superclass is queried for the annotation type. **This annotation applies only to class declarations**.

* `@Repeatable` annotation indicates that the marked annotation can be applied more than once to the same declaration or type use.

## Type Annotation and Pluggable Type Systems 
Annotations can be used anywhere you use a type. For example, class instance creation expressions (new), casts, implements clauses, and throws clauses. This form of annotation is called a *type annotation*.

Type annotations are used to ensure a stronger type checking. The Java SE 8 release does not provide a type checking framework, but it allows you use a type checking framework that is implemented as one or more pluggable modules that are used in conjunction with the Java compiler. For example, you could annotate `@NonNull String str;` to get errors at compile time and  avoid getting a `NullPointerException` at runtime.

In this way, you can build on top of the Java type system, adding specific checks when and where you want them.






