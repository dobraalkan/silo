package com.silo.backend.domain.model.entity.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link UpdateSettingsCommand}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUpdateSettingsCommand.builder()}.
 */
@Generated(from = "UpdateSettingsCommand", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableUpdateSettingsCommand
    extends UpdateSettingsCommand {
  private final String name;
  private final String value;

  private ImmutableUpdateSettingsCommand(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("value")
  @Override
  public String value() {
    return value;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UpdateSettingsCommand#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUpdateSettingsCommand withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableUpdateSettingsCommand(newValue, this.value);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UpdateSettingsCommand#value() value} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for value
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUpdateSettingsCommand withValue(String value) {
    String newValue = Objects.requireNonNull(value, "value");
    if (this.value.equals(newValue)) return this;
    return new ImmutableUpdateSettingsCommand(this.name, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUpdateSettingsCommand} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUpdateSettingsCommand
        && equalTo(0, (ImmutableUpdateSettingsCommand) another);
  }

  private boolean equalTo(int synthetic, ImmutableUpdateSettingsCommand another) {
    return name.equals(another.name)
        && value.equals(another.value);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + value.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UpdateSettingsCommand} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "UpdateSettingsCommand{"
        + "name=" + name
        + ", value=" + value
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "UpdateSettingsCommand", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends UpdateSettingsCommand {
    String name;
    String value;
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("value")
    public void setValue(String value) {
      this.value = value;
    }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public String value() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableUpdateSettingsCommand fromJson(Json json) {
    ImmutableUpdateSettingsCommand.Builder builder = ImmutableUpdateSettingsCommand.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.value != null) {
      builder.value(json.value);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link UpdateSettingsCommand} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UpdateSettingsCommand instance
   */
  public static ImmutableUpdateSettingsCommand copyOf(UpdateSettingsCommand instance) {
    if (instance instanceof ImmutableUpdateSettingsCommand) {
      return (ImmutableUpdateSettingsCommand) instance;
    }
    return ImmutableUpdateSettingsCommand.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand}.
   * <pre>
   * ImmutableUpdateSettingsCommand.builder()
   *    .name(String) // required {@link UpdateSettingsCommand#name() name}
   *    .value(String) // required {@link UpdateSettingsCommand#value() value}
   *    .build();
   * </pre>
   * @return A new ImmutableUpdateSettingsCommand builder
   */
  public static ImmutableUpdateSettingsCommand.Builder builder() {
    return new ImmutableUpdateSettingsCommand.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UpdateSettingsCommand", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_VALUE = 0x2L;
    private long initBits = 0x3L;

    private String name;
    private String value;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UpdateSettingsCommand} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(UpdateSettingsCommand instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      value(instance.value());
      return this;
    }

    /**
     * Initializes the value for the {@link UpdateSettingsCommand#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link UpdateSettingsCommand#value() value} attribute.
     * @param value The value for value 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("value")
    public final Builder value(String value) {
      this.value = Objects.requireNonNull(value, "value");
      initBits &= ~INIT_BIT_VALUE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUpdateSettingsCommand ImmutableUpdateSettingsCommand}.
     * @return An immutable instance of UpdateSettingsCommand
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUpdateSettingsCommand build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUpdateSettingsCommand(name, value);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_VALUE) != 0) attributes.add("value");
      return "Cannot build UpdateSettingsCommand, some of required attributes are not set " + attributes;
    }
  }
}
