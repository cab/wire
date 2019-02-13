// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

/**
 * ===================================================================
 * Options
 * Each of the definitions above may have "options" attached.  These are
 * just annotations which may cause code to be generated slightly differently
 * or may contain hints for code that manipulates protocol messages.
 *
 * Clients may define custom options as extensions of the *Options messages.
 * These extensions may not yet be known at parsing time, so the parser cannot
 * store the values in them.  Instead it stores them in a field in the *Options
 * message called uninterpreted_option. This field must have the same name
 * across all *Options messages. We then use this field to populate the
 * extensions when we build a descriptor, at which point all protos have been
 * parsed and so all extensions are known.
 *
 * Extension numbers for custom options may be chosen as follows:
 * * For options which will only be used within a single application or
 *   organization, or for experimental options, use field numbers 50000
 *   through 99999.  It is up to you to ensure that you do not use the
 *   same number for multiple options.
 * * For options which will be published and used publicly by multiple
 *   independent entities, e-mail protobuf-global-extension-registry@google.com
 *   to reserve extension numbers. Simply provide your project name (e.g.
 *   Objective-C plugin) and your project website (if available) -- there's no
 *   need to explain how you intend to use them. Usually you only need one
 *   extension number. You can declare multiple options with only one extension
 *   number by putting them in a sub-message. See the Custom Options section of
 *   the docs for examples:
 *   https://developers.google.com/protocol-buffers/docs/proto#options
 *   If this turns out to be popular, a web service will be set up
 *   to automatically assign option numbers.
 */
public final class FileOptions extends Message<FileOptions, FileOptions.Builder> {
  public static final ProtoAdapter<FileOptions> ADAPTER = new ProtoAdapter_FileOptions();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_JAVA_PACKAGE = "";

  public static final String DEFAULT_JAVA_OUTER_CLASSNAME = "";

  public static final Boolean DEFAULT_JAVA_MULTIPLE_FILES = false;

  public static final Boolean DEFAULT_JAVA_GENERATE_EQUALS_AND_HASH = false;

  public static final Boolean DEFAULT_JAVA_STRING_CHECK_UTF8 = false;

  public static final OptimizeMode DEFAULT_OPTIMIZE_FOR = OptimizeMode.SPEED;

  public static final String DEFAULT_GO_PACKAGE = "";

  public static final Boolean DEFAULT_CC_GENERIC_SERVICES = false;

  public static final Boolean DEFAULT_JAVA_GENERIC_SERVICES = false;

  public static final Boolean DEFAULT_PY_GENERIC_SERVICES = false;

  public static final Boolean DEFAULT_PHP_GENERIC_SERVICES = false;

  public static final Boolean DEFAULT_DEPRECATED = false;

  public static final Boolean DEFAULT_CC_ENABLE_ARENAS = false;

  public static final String DEFAULT_OBJC_CLASS_PREFIX = "";

  public static final String DEFAULT_CSHARP_NAMESPACE = "";

  public static final String DEFAULT_SWIFT_PREFIX = "";

  public static final String DEFAULT_PHP_CLASS_PREFIX = "";

  public static final String DEFAULT_PHP_NAMESPACE = "";

  /**
   * Sets the Java package where classes generated from this .proto will be
   * placed.  By default, the proto package is used, but this is often
   * inappropriate because proto packages do not normally start with backwards
   * domain names.
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String java_package;

  /**
   * If set, all the classes from the .proto file are wrapped in a single
   * outer class with the given name.  This applies to both Proto1
   * (equivalent to the old "--one_java_file" option) and Proto2 (where
   * a .proto always translates to a single class, but you may want to
   * explicitly choose the class name).
   */
  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String java_outer_classname;

  /**
   * If set true, then the Java code generator will generate a separate .java
   * file for each top-level message, enum, and service defined in the .proto
   * file.  Thus, these types will *not* be nested inside the outer class
   * named by java_outer_classname.  However, the outer class will still be
   * generated to contain the file's getDescriptor() method as well as any
   * top-level extensions defined in the file.
   */
  @WireField(
      tag = 10,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean java_multiple_files;

  /**
   * This option does nothing.
   */
  @WireField(
      tag = 20,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  @Deprecated
  public final Boolean java_generate_equals_and_hash;

  /**
   * If set true, then the Java2 code generator will generate code that
   * throws an exception whenever an attempt is made to assign a non-UTF-8
   * byte sequence to a string field.
   * Message reflection will do the same.
   * However, an extension field still accepts non-UTF-8 byte sequences.
   * This option has no effect on when used with the lite runtime.
   */
  @WireField(
      tag = 27,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean java_string_check_utf8;

  @WireField(
      tag = 9,
      adapter = "com.google.protobuf.FileOptions$OptimizeMode#ADAPTER"
  )
  public final OptimizeMode optimize_for;

  /**
   * Sets the Go package where structs generated from this .proto will be
   * placed. If omitted, the Go package will be derived from the following:
   *   - The basename of the package import path, if provided.
   *   - Otherwise, the package statement in the .proto file, if present.
   *   - Otherwise, the basename of the .proto file, without extension.
   */
  @WireField(
      tag = 11,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String go_package;

  /**
   * Should generic services be generated in each language?  "Generic" services
   * are not specific to any particular RPC system.  They are generated by the
   * main code generators in each language (without additional plugins).
   * Generic services were the only kind of service generation supported by
   * early versions of google.protobuf.
   *
   * Generic services are now considered deprecated in favor of using plugins
   * that generate code specific to your particular RPC system.  Therefore,
   * these default to false.  Old code which depends on generic services should
   * explicitly set them to true.
   */
  @WireField(
      tag = 16,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean cc_generic_services;

  @WireField(
      tag = 17,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean java_generic_services;

  @WireField(
      tag = 18,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean py_generic_services;

  @WireField(
      tag = 42,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean php_generic_services;

  /**
   * Is this file deprecated?
   * Depending on the target platform, this can emit Deprecated annotations
   * for everything in the file, or it will be completely ignored; in the very
   * least, this is a formalization for deprecating files.
   */
  @WireField(
      tag = 23,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean deprecated;

  /**
   * Enables the use of arenas for the proto messages in this file. This applies
   * only to generated classes for C++.
   */
  @WireField(
      tag = 31,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean cc_enable_arenas;

  /**
   * Sets the objective c class prefix which is prepended to all objective c
   * generated classes from this .proto. There is no default.
   */
  @WireField(
      tag = 36,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String objc_class_prefix;

  /**
   * Namespace for generated classes; defaults to the package.
   */
  @WireField(
      tag = 37,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String csharp_namespace;

  /**
   * By default Swift generators will take the proto package and CamelCase it
   * replacing '.' with underscore and use that to prefix the types/symbols
   * defined. When this options is provided, they will use this value instead
   * to prefix the types/symbols defined.
   */
  @WireField(
      tag = 39,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String swift_prefix;

  /**
   * Sets the php class prefix which is prepended to all php generated classes
   * from this .proto. Default is empty.
   */
  @WireField(
      tag = 40,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String php_class_prefix;

  /**
   * Use this option to change the namespace of php generated classes. Default
   * is empty. When this option is empty, the package name will be used for
   * determining the namespace.
   */
  @WireField(
      tag = 41,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String php_namespace;

  /**
   * The parser stores options it doesn't recognize here.
   * See the documentation for the "Options" section above.
   */
  @WireField(
      tag = 999,
      adapter = "com.google.protobuf.UninterpretedOption#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UninterpretedOption> uninterpreted_option;

  public FileOptions(Builder builder, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.java_package = builder.java_package;
    this.java_outer_classname = builder.java_outer_classname;
    this.java_multiple_files = builder.java_multiple_files;
    this.java_generate_equals_and_hash = builder.java_generate_equals_and_hash;
    this.java_string_check_utf8 = builder.java_string_check_utf8;
    this.optimize_for = builder.optimize_for;
    this.go_package = builder.go_package;
    this.cc_generic_services = builder.cc_generic_services;
    this.java_generic_services = builder.java_generic_services;
    this.py_generic_services = builder.py_generic_services;
    this.php_generic_services = builder.php_generic_services;
    this.deprecated = builder.deprecated;
    this.cc_enable_arenas = builder.cc_enable_arenas;
    this.objc_class_prefix = builder.objc_class_prefix;
    this.csharp_namespace = builder.csharp_namespace;
    this.swift_prefix = builder.swift_prefix;
    this.php_class_prefix = builder.php_class_prefix;
    this.php_namespace = builder.php_namespace;
    this.uninterpreted_option = Internal.INSTANCE.immutableCopyOf("uninterpreted_option", builder.uninterpreted_option);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.java_package = java_package;
    builder.java_outer_classname = java_outer_classname;
    builder.java_multiple_files = java_multiple_files;
    builder.java_generate_equals_and_hash = java_generate_equals_and_hash;
    builder.java_string_check_utf8 = java_string_check_utf8;
    builder.optimize_for = optimize_for;
    builder.go_package = go_package;
    builder.cc_generic_services = cc_generic_services;
    builder.java_generic_services = java_generic_services;
    builder.py_generic_services = py_generic_services;
    builder.php_generic_services = php_generic_services;
    builder.deprecated = deprecated;
    builder.cc_enable_arenas = cc_enable_arenas;
    builder.objc_class_prefix = objc_class_prefix;
    builder.csharp_namespace = csharp_namespace;
    builder.swift_prefix = swift_prefix;
    builder.php_class_prefix = php_class_prefix;
    builder.php_namespace = php_namespace;
    builder.uninterpreted_option = Internal.INSTANCE.copyOf("uninterpreted_option", uninterpreted_option);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof FileOptions)) return false;
    FileOptions o = (FileOptions) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.INSTANCE.equals(java_package, o.java_package)
        && Internal.INSTANCE.equals(java_outer_classname, o.java_outer_classname)
        && Internal.INSTANCE.equals(java_multiple_files, o.java_multiple_files)
        && Internal.INSTANCE.equals(java_generate_equals_and_hash, o.java_generate_equals_and_hash)
        && Internal.INSTANCE.equals(java_string_check_utf8, o.java_string_check_utf8)
        && Internal.INSTANCE.equals(optimize_for, o.optimize_for)
        && Internal.INSTANCE.equals(go_package, o.go_package)
        && Internal.INSTANCE.equals(cc_generic_services, o.cc_generic_services)
        && Internal.INSTANCE.equals(java_generic_services, o.java_generic_services)
        && Internal.INSTANCE.equals(py_generic_services, o.py_generic_services)
        && Internal.INSTANCE.equals(php_generic_services, o.php_generic_services)
        && Internal.INSTANCE.equals(deprecated, o.deprecated)
        && Internal.INSTANCE.equals(cc_enable_arenas, o.cc_enable_arenas)
        && Internal.INSTANCE.equals(objc_class_prefix, o.objc_class_prefix)
        && Internal.INSTANCE.equals(csharp_namespace, o.csharp_namespace)
        && Internal.INSTANCE.equals(swift_prefix, o.swift_prefix)
        && Internal.INSTANCE.equals(php_class_prefix, o.php_class_prefix)
        && Internal.INSTANCE.equals(php_namespace, o.php_namespace)
        && uninterpreted_option.equals(o.uninterpreted_option);
  }

  @Override
  public int hashCode() {
    int result = super.getHashCode();
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (java_package != null ? java_package.hashCode() : 0);
      result = result * 37 + (java_outer_classname != null ? java_outer_classname.hashCode() : 0);
      result = result * 37 + (java_multiple_files != null ? java_multiple_files.hashCode() : 0);
      result = result * 37 + (java_generate_equals_and_hash != null ? java_generate_equals_and_hash.hashCode() : 0);
      result = result * 37 + (java_string_check_utf8 != null ? java_string_check_utf8.hashCode() : 0);
      result = result * 37 + (optimize_for != null ? optimize_for.hashCode() : 0);
      result = result * 37 + (go_package != null ? go_package.hashCode() : 0);
      result = result * 37 + (cc_generic_services != null ? cc_generic_services.hashCode() : 0);
      result = result * 37 + (java_generic_services != null ? java_generic_services.hashCode() : 0);
      result = result * 37 + (py_generic_services != null ? py_generic_services.hashCode() : 0);
      result = result * 37 + (php_generic_services != null ? php_generic_services.hashCode() : 0);
      result = result * 37 + (deprecated != null ? deprecated.hashCode() : 0);
      result = result * 37 + (cc_enable_arenas != null ? cc_enable_arenas.hashCode() : 0);
      result = result * 37 + (objc_class_prefix != null ? objc_class_prefix.hashCode() : 0);
      result = result * 37 + (csharp_namespace != null ? csharp_namespace.hashCode() : 0);
      result = result * 37 + (swift_prefix != null ? swift_prefix.hashCode() : 0);
      result = result * 37 + (php_class_prefix != null ? php_class_prefix.hashCode() : 0);
      result = result * 37 + (php_namespace != null ? php_namespace.hashCode() : 0);
      result = result * 37 + uninterpreted_option.hashCode();
      super.setHashCode(result);
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (java_package != null) builder.append(", java_package=").append(java_package);
    if (java_outer_classname != null) builder.append(", java_outer_classname=").append(java_outer_classname);
    if (java_multiple_files != null) builder.append(", java_multiple_files=").append(java_multiple_files);
    if (java_generate_equals_and_hash != null) builder.append(", java_generate_equals_and_hash=").append(java_generate_equals_and_hash);
    if (java_string_check_utf8 != null) builder.append(", java_string_check_utf8=").append(java_string_check_utf8);
    if (optimize_for != null) builder.append(", optimize_for=").append(optimize_for);
    if (go_package != null) builder.append(", go_package=").append(go_package);
    if (cc_generic_services != null) builder.append(", cc_generic_services=").append(cc_generic_services);
    if (java_generic_services != null) builder.append(", java_generic_services=").append(java_generic_services);
    if (py_generic_services != null) builder.append(", py_generic_services=").append(py_generic_services);
    if (php_generic_services != null) builder.append(", php_generic_services=").append(php_generic_services);
    if (deprecated != null) builder.append(", deprecated=").append(deprecated);
    if (cc_enable_arenas != null) builder.append(", cc_enable_arenas=").append(cc_enable_arenas);
    if (objc_class_prefix != null) builder.append(", objc_class_prefix=").append(objc_class_prefix);
    if (csharp_namespace != null) builder.append(", csharp_namespace=").append(csharp_namespace);
    if (swift_prefix != null) builder.append(", swift_prefix=").append(swift_prefix);
    if (php_class_prefix != null) builder.append(", php_class_prefix=").append(php_class_prefix);
    if (php_namespace != null) builder.append(", php_namespace=").append(php_namespace);
    if (!uninterpreted_option.isEmpty()) builder.append(", uninterpreted_option=").append(uninterpreted_option);
    return builder.replace(0, 2, "FileOptions{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<FileOptions, Builder> {
    public String java_package;

    public String java_outer_classname;

    public Boolean java_multiple_files;

    public Boolean java_generate_equals_and_hash;

    public Boolean java_string_check_utf8;

    public OptimizeMode optimize_for;

    public String go_package;

    public Boolean cc_generic_services;

    public Boolean java_generic_services;

    public Boolean py_generic_services;

    public Boolean php_generic_services;

    public Boolean deprecated;

    public Boolean cc_enable_arenas;

    public String objc_class_prefix;

    public String csharp_namespace;

    public String swift_prefix;

    public String php_class_prefix;

    public String php_namespace;

    public List<UninterpretedOption> uninterpreted_option;

    public Builder() {
      uninterpreted_option = Internal.INSTANCE.newMutableList();
    }

    /**
     * Sets the Java package where classes generated from this .proto will be
     * placed.  By default, the proto package is used, but this is often
     * inappropriate because proto packages do not normally start with backwards
     * domain names.
     */
    public Builder java_package(String java_package) {
      this.java_package = java_package;
      return this;
    }

    /**
     * If set, all the classes from the .proto file are wrapped in a single
     * outer class with the given name.  This applies to both Proto1
     * (equivalent to the old "--one_java_file" option) and Proto2 (where
     * a .proto always translates to a single class, but you may want to
     * explicitly choose the class name).
     */
    public Builder java_outer_classname(String java_outer_classname) {
      this.java_outer_classname = java_outer_classname;
      return this;
    }

    /**
     * If set true, then the Java code generator will generate a separate .java
     * file for each top-level message, enum, and service defined in the .proto
     * file.  Thus, these types will *not* be nested inside the outer class
     * named by java_outer_classname.  However, the outer class will still be
     * generated to contain the file's getDescriptor() method as well as any
     * top-level extensions defined in the file.
     */
    public Builder java_multiple_files(Boolean java_multiple_files) {
      this.java_multiple_files = java_multiple_files;
      return this;
    }

    /**
     * This option does nothing.
     */
    @Deprecated
    public Builder java_generate_equals_and_hash(Boolean java_generate_equals_and_hash) {
      this.java_generate_equals_and_hash = java_generate_equals_and_hash;
      return this;
    }

    /**
     * If set true, then the Java2 code generator will generate code that
     * throws an exception whenever an attempt is made to assign a non-UTF-8
     * byte sequence to a string field.
     * Message reflection will do the same.
     * However, an extension field still accepts non-UTF-8 byte sequences.
     * This option has no effect on when used with the lite runtime.
     */
    public Builder java_string_check_utf8(Boolean java_string_check_utf8) {
      this.java_string_check_utf8 = java_string_check_utf8;
      return this;
    }

    public Builder optimize_for(OptimizeMode optimize_for) {
      this.optimize_for = optimize_for;
      return this;
    }

    /**
     * Sets the Go package where structs generated from this .proto will be
     * placed. If omitted, the Go package will be derived from the following:
     *   - The basename of the package import path, if provided.
     *   - Otherwise, the package statement in the .proto file, if present.
     *   - Otherwise, the basename of the .proto file, without extension.
     */
    public Builder go_package(String go_package) {
      this.go_package = go_package;
      return this;
    }

    /**
     * Should generic services be generated in each language?  "Generic" services
     * are not specific to any particular RPC system.  They are generated by the
     * main code generators in each language (without additional plugins).
     * Generic services were the only kind of service generation supported by
     * early versions of google.protobuf.
     *
     * Generic services are now considered deprecated in favor of using plugins
     * that generate code specific to your particular RPC system.  Therefore,
     * these default to false.  Old code which depends on generic services should
     * explicitly set them to true.
     */
    public Builder cc_generic_services(Boolean cc_generic_services) {
      this.cc_generic_services = cc_generic_services;
      return this;
    }

    public Builder java_generic_services(Boolean java_generic_services) {
      this.java_generic_services = java_generic_services;
      return this;
    }

    public Builder py_generic_services(Boolean py_generic_services) {
      this.py_generic_services = py_generic_services;
      return this;
    }

    public Builder php_generic_services(Boolean php_generic_services) {
      this.php_generic_services = php_generic_services;
      return this;
    }

    /**
     * Is this file deprecated?
     * Depending on the target platform, this can emit Deprecated annotations
     * for everything in the file, or it will be completely ignored; in the very
     * least, this is a formalization for deprecating files.
     */
    public Builder deprecated(Boolean deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /**
     * Enables the use of arenas for the proto messages in this file. This applies
     * only to generated classes for C++.
     */
    public Builder cc_enable_arenas(Boolean cc_enable_arenas) {
      this.cc_enable_arenas = cc_enable_arenas;
      return this;
    }

    /**
     * Sets the objective c class prefix which is prepended to all objective c
     * generated classes from this .proto. There is no default.
     */
    public Builder objc_class_prefix(String objc_class_prefix) {
      this.objc_class_prefix = objc_class_prefix;
      return this;
    }

    /**
     * Namespace for generated classes; defaults to the package.
     */
    public Builder csharp_namespace(String csharp_namespace) {
      this.csharp_namespace = csharp_namespace;
      return this;
    }

    /**
     * By default Swift generators will take the proto package and CamelCase it
     * replacing '.' with underscore and use that to prefix the types/symbols
     * defined. When this options is provided, they will use this value instead
     * to prefix the types/symbols defined.
     */
    public Builder swift_prefix(String swift_prefix) {
      this.swift_prefix = swift_prefix;
      return this;
    }

    /**
     * Sets the php class prefix which is prepended to all php generated classes
     * from this .proto. Default is empty.
     */
    public Builder php_class_prefix(String php_class_prefix) {
      this.php_class_prefix = php_class_prefix;
      return this;
    }

    /**
     * Use this option to change the namespace of php generated classes. Default
     * is empty. When this option is empty, the package name will be used for
     * determining the namespace.
     */
    public Builder php_namespace(String php_namespace) {
      this.php_namespace = php_namespace;
      return this;
    }

    /**
     * The parser stores options it doesn't recognize here.
     * See the documentation for the "Options" section above.
     */
    public Builder uninterpreted_option(List<UninterpretedOption> uninterpreted_option) {
      Internal.INSTANCE.checkElementsNotNull(uninterpreted_option);
      this.uninterpreted_option = uninterpreted_option;
      return this;
    }

    @Override
    public FileOptions build() {
      return new FileOptions(this, super.buildUnknownFields());
    }
  }

  /**
   * Generated classes can be optimized for speed or code size.
   */
  public enum OptimizeMode implements WireEnum {
    /**
     * Generate complete code for parsing, serialization,
     */
    SPEED(1),

    /**
     * etc.
     * Use ReflectionOps to implement these methods.
     */
    CODE_SIZE(2),

    /**
     * Generate code using MessageLite and the lite runtime.
     */
    LITE_RUNTIME(3);

    public static final ProtoAdapter<OptimizeMode> ADAPTER = new ProtoAdapter_OptimizeMode();

    private final int value;

    OptimizeMode(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static OptimizeMode fromValue(int value) {
      switch (value) {
        case 1: return SPEED;
        case 2: return CODE_SIZE;
        case 3: return LITE_RUNTIME;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }

    private static final class ProtoAdapter_OptimizeMode extends EnumAdapter<OptimizeMode> {
      ProtoAdapter_OptimizeMode() {
        super(OptimizeMode.class);
      }

      @Override
      protected OptimizeMode fromValue(int value) {
        return OptimizeMode.fromValue(value);
      }
    }
  }

  private static final class ProtoAdapter_FileOptions extends ProtoAdapter<FileOptions> {
    public ProtoAdapter_FileOptions() {
      super(FieldEncoding.LENGTH_DELIMITED, FileOptions.class);
    }

    @Override
    public int encodedSize(FileOptions value) {
      return ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(1, value.java_package)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(8, value.java_outer_classname)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(10, value.java_multiple_files)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(20, value.java_generate_equals_and_hash)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(27, value.java_string_check_utf8)
          + OptimizeMode.ADAPTER.encodedSizeWithTag(9, value.optimize_for)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(11, value.go_package)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(16, value.cc_generic_services)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(17, value.java_generic_services)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(18, value.py_generic_services)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(42, value.php_generic_services)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(23, value.deprecated)
          + ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(31, value.cc_enable_arenas)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(36, value.objc_class_prefix)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(37, value.csharp_namespace)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(39, value.swift_prefix)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(40, value.php_class_prefix)
          + ProtoAdapter.Companion.getSTRING().encodedSizeWithTag(41, value.php_namespace)
          + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, value.uninterpreted_option)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, FileOptions value) throws IOException {
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 1, value.java_package);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 8, value.java_outer_classname);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 10, value.java_multiple_files);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 20, value.java_generate_equals_and_hash);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 27, value.java_string_check_utf8);
      OptimizeMode.ADAPTER.encodeWithTag(writer, 9, value.optimize_for);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 11, value.go_package);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 16, value.cc_generic_services);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 17, value.java_generic_services);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 18, value.py_generic_services);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 42, value.php_generic_services);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 23, value.deprecated);
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 31, value.cc_enable_arenas);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 36, value.objc_class_prefix);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 37, value.csharp_namespace);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 39, value.swift_prefix);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 40, value.php_class_prefix);
      ProtoAdapter.Companion.getSTRING().encodeWithTag(writer, 41, value.php_namespace);
      UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(writer, 999, value.uninterpreted_option);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public FileOptions decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.java_package(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 8: builder.java_outer_classname(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 9: {
            try {
              builder.optimize_for(OptimizeMode.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.getValue());
            }
            break;
          }
          case 10: builder.java_multiple_files(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 11: builder.go_package(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 16: builder.cc_generic_services(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 17: builder.java_generic_services(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 18: builder.py_generic_services(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 20: builder.java_generate_equals_and_hash(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 23: builder.deprecated(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 27: builder.java_string_check_utf8(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 31: builder.cc_enable_arenas(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 36: builder.objc_class_prefix(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 37: builder.csharp_namespace(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 39: builder.swift_prefix(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 40: builder.php_class_prefix(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 41: builder.php_namespace(ProtoAdapter.Companion.getSTRING().decode(reader)); break;
          case 42: builder.php_generic_services(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
          case 999: builder.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public FileOptions redact(FileOptions value) {
      Builder builder = value.newBuilder();
      Internal.INSTANCE.redactElements(builder.uninterpreted_option, UninterpretedOption.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
