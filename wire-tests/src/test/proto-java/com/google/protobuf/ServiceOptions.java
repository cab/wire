// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

public final class ServiceOptions extends Message<ServiceOptions, ServiceOptions.Builder> {
  public static final ProtoAdapter<ServiceOptions> ADAPTER = new ProtoAdapter_ServiceOptions();

  private static final long serialVersionUID = 0L;

  public static final Boolean DEFAULT_DEPRECATED = false;

  /**
   * Note:  Field numbers 1 through 32 are reserved for Google's internal RPC
   *   framework.  We apologize for hoarding these numbers to ourselves, but
   *   we were already using them long before we decided to release Protocol
   *   Buffers.
   * Is this service deprecated?
   * Depending on the target platform, this can emit Deprecated annotations
   * for the service, or it will be completely ignored; in the very least,
   * this is a formalization for deprecating services.
   */
  @WireField(
      tag = 33,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean deprecated;

  /**
   * The parser stores options it doesn't recognize here. See above.
   */
  @WireField(
      tag = 999,
      adapter = "com.google.protobuf.UninterpretedOption#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UninterpretedOption> uninterpreted_option;

  public ServiceOptions(Boolean deprecated, List<UninterpretedOption> uninterpreted_option) {
    this(deprecated, uninterpreted_option, ByteString.EMPTY);
  }

  public ServiceOptions(Boolean deprecated, List<UninterpretedOption> uninterpreted_option,
      ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.deprecated = deprecated;
    this.uninterpreted_option = Internal.INSTANCE.immutableCopyOf("uninterpreted_option", uninterpreted_option);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.deprecated = deprecated;
    builder.uninterpreted_option = Internal.INSTANCE.copyOf("uninterpreted_option", uninterpreted_option);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof ServiceOptions)) return false;
    ServiceOptions o = (ServiceOptions) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.INSTANCE.equals(deprecated, o.deprecated)
        && uninterpreted_option.equals(o.uninterpreted_option);
  }

  @Override
  public int hashCode() {
    int result = super.getHashCode();
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (deprecated != null ? deprecated.hashCode() : 0);
      result = result * 37 + uninterpreted_option.hashCode();
      super.setHashCode(result);
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (deprecated != null) builder.append(", deprecated=").append(deprecated);
    if (!uninterpreted_option.isEmpty()) builder.append(", uninterpreted_option=").append(uninterpreted_option);
    return builder.replace(0, 2, "ServiceOptions{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<ServiceOptions, Builder> {
    public Boolean deprecated;

    public List<UninterpretedOption> uninterpreted_option;

    public Builder() {
      uninterpreted_option = Internal.INSTANCE.newMutableList();
    }

    /**
     * Note:  Field numbers 1 through 32 are reserved for Google's internal RPC
     *   framework.  We apologize for hoarding these numbers to ourselves, but
     *   we were already using them long before we decided to release Protocol
     *   Buffers.
     * Is this service deprecated?
     * Depending on the target platform, this can emit Deprecated annotations
     * for the service, or it will be completely ignored; in the very least,
     * this is a formalization for deprecating services.
     */
    public Builder deprecated(Boolean deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    /**
     * The parser stores options it doesn't recognize here. See above.
     */
    public Builder uninterpreted_option(List<UninterpretedOption> uninterpreted_option) {
      Internal.INSTANCE.checkElementsNotNull(uninterpreted_option);
      this.uninterpreted_option = uninterpreted_option;
      return this;
    }

    @Override
    public ServiceOptions build() {
      return new ServiceOptions(deprecated, uninterpreted_option, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_ServiceOptions extends ProtoAdapter<ServiceOptions> {
    public ProtoAdapter_ServiceOptions() {
      super(FieldEncoding.LENGTH_DELIMITED, ServiceOptions.class);
    }

    @Override
    public int encodedSize(ServiceOptions value) {
      return ProtoAdapter.Companion.getBOOL().encodedSizeWithTag(33, value.deprecated)
          + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, value.uninterpreted_option)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, ServiceOptions value) throws IOException {
      ProtoAdapter.Companion.getBOOL().encodeWithTag(writer, 33, value.deprecated);
      UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(writer, 999, value.uninterpreted_option);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public ServiceOptions decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 33: builder.deprecated(ProtoAdapter.Companion.getBOOL().decode(reader)); break;
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
    public ServiceOptions redact(ServiceOptions value) {
      Builder builder = value.newBuilder();
      Internal.INSTANCE.redactElements(builder.uninterpreted_option, UninterpretedOption.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
