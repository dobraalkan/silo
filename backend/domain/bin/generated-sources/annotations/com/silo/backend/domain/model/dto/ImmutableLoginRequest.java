package com.silo.backend.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link LoginRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableLoginRequest.builder()}.
 */
@Generated(from = "LoginRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableLoginRequest extends LoginRequest {
  private final String userName;
  private final String password;

  private ImmutableLoginRequest(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  /**
   * @return The value of the {@code userName} attribute
   */
  @JsonProperty("userName")
  @Override
  public String userName() {
    return userName;
  }

  /**
   * @return The value of the {@code password} attribute
   */
  @JsonProperty("password")
  @Override
  public String password() {
    return password;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LoginRequest#userName() userName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for userName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLoginRequest withUserName(String value) {
    String newValue = Objects.requireNonNull(value, "userName");
    if (this.userName.equals(newValue)) return this;
    return new ImmutableLoginRequest(newValue, this.password);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LoginRequest#password() password} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for password
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLoginRequest withPassword(String value) {
    String newValue = Objects.requireNonNull(value, "password");
    if (this.password.equals(newValue)) return this;
    return new ImmutableLoginRequest(this.userName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableLoginRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableLoginRequest
        && equalTo(0, (ImmutableLoginRequest) another);
  }

  private boolean equalTo(int synthetic, ImmutableLoginRequest another) {
    return userName.equals(another.userName)
        && password.equals(another.password);
  }

  /**
   * Computes a hash code from attributes: {@code userName}, {@code password}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + userName.hashCode();
    h += (h << 5) + password.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code LoginRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "LoginRequest{"
        + "userName=" + userName
        + ", password=" + password
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "LoginRequest", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends LoginRequest {
    String userName;
    String password;
    @JsonProperty("userName")
    public void setUserName(String userName) {
      this.userName = userName;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
      this.password = password;
    }
    @Override
    public String userName() { throw new UnsupportedOperationException(); }
    @Override
    public String password() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableLoginRequest fromJson(Json json) {
    ImmutableLoginRequest.Builder builder = ImmutableLoginRequest.builder();
    if (json.userName != null) {
      builder.userName(json.userName);
    }
    if (json.password != null) {
      builder.password(json.password);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link LoginRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable LoginRequest instance
   */
  public static ImmutableLoginRequest copyOf(LoginRequest instance) {
    if (instance instanceof ImmutableLoginRequest) {
      return (ImmutableLoginRequest) instance;
    }
    return ImmutableLoginRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableLoginRequest ImmutableLoginRequest}.
   * <pre>
   * ImmutableLoginRequest.builder()
   *    .userName(String) // required {@link LoginRequest#userName() userName}
   *    .password(String) // required {@link LoginRequest#password() password}
   *    .build();
   * </pre>
   * @return A new ImmutableLoginRequest builder
   */
  public static ImmutableLoginRequest.Builder builder() {
    return new ImmutableLoginRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableLoginRequest ImmutableLoginRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "LoginRequest", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_USER_NAME = 0x1L;
    private static final long INIT_BIT_PASSWORD = 0x2L;
    private long initBits = 0x3L;

    private String userName;
    private String password;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code LoginRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(LoginRequest instance) {
      Objects.requireNonNull(instance, "instance");
      userName(instance.userName());
      password(instance.password());
      return this;
    }

    /**
     * Initializes the value for the {@link LoginRequest#userName() userName} attribute.
     * @param userName The value for userName 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("userName")
    public final Builder userName(String userName) {
      this.userName = Objects.requireNonNull(userName, "userName");
      initBits &= ~INIT_BIT_USER_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link LoginRequest#password() password} attribute.
     * @param password The value for password 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("password")
    public final Builder password(String password) {
      this.password = Objects.requireNonNull(password, "password");
      initBits &= ~INIT_BIT_PASSWORD;
      return this;
    }

    /**
     * Builds a new {@link ImmutableLoginRequest ImmutableLoginRequest}.
     * @return An immutable instance of LoginRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableLoginRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableLoginRequest(userName, password);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_USER_NAME) != 0) attributes.add("userName");
      if ((initBits & INIT_BIT_PASSWORD) != 0) attributes.add("password");
      return "Cannot build LoginRequest, some of required attributes are not set " + attributes;
    }
  }
}
