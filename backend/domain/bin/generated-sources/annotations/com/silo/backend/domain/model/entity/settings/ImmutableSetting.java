package com.silo.backend.domain.model.entity.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Setting}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSetting.builder()}.
 */
@Generated(from = "Setting", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableSetting extends Setting {
  private final String name;
  private final @Nullable String description;
  private final String value;
  private final boolean restricted;

  private ImmutableSetting(ImmutableSetting.Builder builder) {
    this.name = builder.name;
    this.description = builder.description;
    this.value = builder.value;
    this.restricted = builder.restrictedIsSet()
        ? builder.restricted
        : super.restricted();
  }

  private ImmutableSetting(
      String name,
      @Nullable String description,
      String value,
      boolean restricted) {
    this.name = name;
    this.description = description;
    this.value = value;
    this.restricted = restricted;
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
   * @return The value of the {@code description} attribute
   */
  @JsonProperty("description")
  @Override
  public @Nullable String description() {
    return description;
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @JsonProperty("value")
  @Override
  public Optional<String> value() {
    return Optional.ofNullable(value);
  }

  /**
   * @return The value of the {@code restricted} attribute
   */
  @JsonProperty("restricted")
  @Override
  public boolean restricted() {
    return restricted;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Setting#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSetting withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableSetting(newValue, this.description, this.value, this.restricted);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Setting#description() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for description (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSetting withDescription(@Nullable String value) {
    if (Objects.equals(this.description, value)) return this;
    return new ImmutableSetting(this.name, value, this.value, this.restricted);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Setting#value() value} attribute.
   * @param value The value for value
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSetting withValue(String value) {
    String newValue = Objects.requireNonNull(value, "value");
    if (Objects.equals(this.value, newValue)) return this;
    return new ImmutableSetting(this.name, this.description, newValue, this.restricted);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Setting#value() value} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for value
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSetting withValue(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.value, value)) return this;
    return new ImmutableSetting(this.name, this.description, value, this.restricted);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Setting#restricted() restricted} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for restricted
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSetting withRestricted(boolean value) {
    if (this.restricted == value) return this;
    return new ImmutableSetting(this.name, this.description, this.value, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSetting} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSetting
        && equalTo(0, (ImmutableSetting) another);
  }

  private boolean equalTo(int synthetic, ImmutableSetting another) {
    return name.equals(another.name)
        && Objects.equals(value, another.value)
        && restricted == another.restricted;
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code value}, {@code restricted}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + Objects.hashCode(value);
    h += (h << 5) + Boolean.hashCode(restricted);
    return h;
  }

  /**
   * Prints the immutable value {@code Setting} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Setting{");
    builder.append("name=").append(name);
    if (value != null) {
      builder.append(", ");
      builder.append("value=").append(value);
    }
    builder.append(", ");
    builder.append("restricted=").append(restricted);
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Setting", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends Setting {
    String name;
    String description;
    Optional<String> value = Optional.empty();
    boolean restricted;
    boolean restrictedIsSet;
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("description")
    public void setDescription(@Nullable String description) {
      this.description = description;
    }
    @JsonProperty("value")
    public void setValue(Optional<String> value) {
      this.value = value;
    }
    @JsonProperty("restricted")
    public void setRestricted(boolean restricted) {
      this.restricted = restricted;
      this.restrictedIsSet = true;
    }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public String description() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> value() { throw new UnsupportedOperationException(); }
    @Override
    public boolean restricted() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableSetting fromJson(Json json) {
    ImmutableSetting.Builder builder = ImmutableSetting.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.value != null) {
      builder.value(json.value);
    }
    if (json.restrictedIsSet) {
      builder.restricted(json.restricted);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Setting} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Setting instance
   */
  public static ImmutableSetting copyOf(Setting instance) {
    if (instance instanceof ImmutableSetting) {
      return (ImmutableSetting) instance;
    }
    return ImmutableSetting.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSetting ImmutableSetting}.
   * <pre>
   * ImmutableSetting.builder()
   *    .name(String) // required {@link Setting#name() name}
   *    .description(String | null) // nullable {@link Setting#description() description}
   *    .value(String) // optional {@link Setting#value() value}
   *    .restricted(boolean) // optional {@link Setting#restricted() restricted}
   *    .build();
   * </pre>
   * @return A new ImmutableSetting builder
   */
  public static ImmutableSetting.Builder builder() {
    return new ImmutableSetting.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSetting ImmutableSetting}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Setting", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long OPT_BIT_RESTRICTED = 0x1L;
    private long initBits = 0x1L;
    private long optBits;

    private String name;
    private String description;
    private String value;
    private boolean restricted;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.silo.backend.domain.model.entity.settings.Setting} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Setting instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.silo.backend.domain.model.entity.settings.NameProvider} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NameProvider instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code com.silo.backend.domain.model.entity.settings.DescriptionProvider} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DescriptionProvider instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      long bits = 0;
      if (object instanceof Setting) {
        Setting instance = (Setting) object;
        if ((bits & 0x1L) == 0) {
          name(instance.name());
          bits |= 0x1L;
        }
        if ((bits & 0x2L) == 0) {
          @Nullable String descriptionValue = instance.description();
          if (descriptionValue != null) {
            description(descriptionValue);
          }
          bits |= 0x2L;
        }
        Optional<String> valueOptional = instance.value();
        if (valueOptional.isPresent()) {
          value(valueOptional);
        }
        restricted(instance.restricted());
      }
      if (object instanceof NameProvider) {
        NameProvider instance = (NameProvider) object;
        if ((bits & 0x1L) == 0) {
          name(instance.name());
          bits |= 0x1L;
        }
      }
      if (object instanceof DescriptionProvider) {
        DescriptionProvider instance = (DescriptionProvider) object;
        if ((bits & 0x2L) == 0) {
          @Nullable String descriptionValue = instance.description();
          if (descriptionValue != null) {
            description(descriptionValue);
          }
          bits |= 0x2L;
        }
      }
    }

    /**
     * Initializes the value for the {@link Setting#name() name} attribute.
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
     * Initializes the value for the {@link Setting#description() description} attribute.
     * @param description The value for description (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("description")
    public final Builder description(@Nullable String description) {
      this.description = description;
      return this;
    }

    /**
     * Initializes the optional value {@link Setting#value() value} to value.
     * @param value The value for value
     * @return {@code this} builder for chained invocation
     */
    public final Builder value(String value) {
      this.value = Objects.requireNonNull(value, "value");
      return this;
    }

    /**
     * Initializes the optional value {@link Setting#value() value} to value.
     * @param value The value for value
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("value")
    public final Builder value(Optional<String> value) {
      this.value = value.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link Setting#restricted() restricted} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Setting#restricted() restricted}.</em>
     * @param restricted The value for restricted 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("restricted")
    public final Builder restricted(boolean restricted) {
      this.restricted = restricted;
      optBits |= OPT_BIT_RESTRICTED;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSetting ImmutableSetting}.
     * @return An immutable instance of Setting
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSetting build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSetting(this);
    }

    private boolean restrictedIsSet() {
      return (optBits & OPT_BIT_RESTRICTED) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build Setting, some of required attributes are not set " + attributes;
    }
  }
}
