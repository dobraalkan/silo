package com.silo.backend.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PasswordResetRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePasswordResetRequest.builder()}.
 */
@Generated(from = "PasswordResetRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutablePasswordResetRequest
    extends PasswordResetRequest {
  private final String userName;
  private final @Nullable String currentPassword;
  private final String newPassword;

  private ImmutablePasswordResetRequest(
      String userName,
      @Nullable String currentPassword,
      String newPassword) {
    this.userName = userName;
    this.currentPassword = currentPassword;
    this.newPassword = newPassword;
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
   * @return The value of the {@code currentPassword} attribute
   */
  @JsonProperty("currentPassword")
  @Override
  public @Nullable String currentPassword() {
    return currentPassword;
  }

  /**
   * @return The value of the {@code newPassword} attribute
   */
  @JsonProperty("newPassword")
  @Override
  public String newPassword() {
    return newPassword;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PasswordResetRequest#userName() userName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for userName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePasswordResetRequest withUserName(String value) {
    String newValue = Objects.requireNonNull(value, "userName");
    if (this.userName.equals(newValue)) return this;
    return new ImmutablePasswordResetRequest(newValue, this.currentPassword, this.newPassword);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PasswordResetRequest#currentPassword() currentPassword} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for currentPassword (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePasswordResetRequest withCurrentPassword(@Nullable String value) {
    if (Objects.equals(this.currentPassword, value)) return this;
    return new ImmutablePasswordResetRequest(this.userName, value, this.newPassword);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PasswordResetRequest#newPassword() newPassword} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for newPassword
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePasswordResetRequest withNewPassword(String value) {
    String newValue = Objects.requireNonNull(value, "newPassword");
    if (this.newPassword.equals(newValue)) return this;
    return new ImmutablePasswordResetRequest(this.userName, this.currentPassword, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePasswordResetRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePasswordResetRequest
        && equalTo(0, (ImmutablePasswordResetRequest) another);
  }

  private boolean equalTo(int synthetic, ImmutablePasswordResetRequest another) {
    return userName.equals(another.userName)
        && Objects.equals(currentPassword, another.currentPassword)
        && newPassword.equals(another.newPassword);
  }

  /**
   * Computes a hash code from attributes: {@code userName}, {@code currentPassword}, {@code newPassword}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + userName.hashCode();
    h += (h << 5) + Objects.hashCode(currentPassword);
    h += (h << 5) + newPassword.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PasswordResetRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PasswordResetRequest{"
        + "userName=" + userName
        + ", currentPassword=" + currentPassword
        + ", newPassword=" + newPassword
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PasswordResetRequest", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends PasswordResetRequest {
    String userName;
    String currentPassword;
    String newPassword;
    @JsonProperty("userName")
    public void setUserName(String userName) {
      this.userName = userName;
    }
    @JsonProperty("currentPassword")
    public void setCurrentPassword(@Nullable String currentPassword) {
      this.currentPassword = currentPassword;
    }
    @JsonProperty("newPassword")
    public void setNewPassword(String newPassword) {
      this.newPassword = newPassword;
    }
    @Override
    public String userName() { throw new UnsupportedOperationException(); }
    @Override
    public String currentPassword() { throw new UnsupportedOperationException(); }
    @Override
    public String newPassword() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePasswordResetRequest fromJson(Json json) {
    ImmutablePasswordResetRequest.Builder builder = ImmutablePasswordResetRequest.builder();
    if (json.userName != null) {
      builder.userName(json.userName);
    }
    if (json.currentPassword != null) {
      builder.currentPassword(json.currentPassword);
    }
    if (json.newPassword != null) {
      builder.newPassword(json.newPassword);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PasswordResetRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PasswordResetRequest instance
   */
  public static ImmutablePasswordResetRequest copyOf(PasswordResetRequest instance) {
    if (instance instanceof ImmutablePasswordResetRequest) {
      return (ImmutablePasswordResetRequest) instance;
    }
    return ImmutablePasswordResetRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePasswordResetRequest ImmutablePasswordResetRequest}.
   * <pre>
   * ImmutablePasswordResetRequest.builder()
   *    .userName(String) // required {@link PasswordResetRequest#userName() userName}
   *    .currentPassword(String | null) // nullable {@link PasswordResetRequest#currentPassword() currentPassword}
   *    .newPassword(String) // required {@link PasswordResetRequest#newPassword() newPassword}
   *    .build();
   * </pre>
   * @return A new ImmutablePasswordResetRequest builder
   */
  public static ImmutablePasswordResetRequest.Builder builder() {
    return new ImmutablePasswordResetRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePasswordResetRequest ImmutablePasswordResetRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PasswordResetRequest", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_USER_NAME = 0x1L;
    private static final long INIT_BIT_NEW_PASSWORD = 0x2L;
    private long initBits = 0x3L;

    private String userName;
    private String currentPassword;
    private String newPassword;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PasswordResetRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PasswordResetRequest instance) {
      Objects.requireNonNull(instance, "instance");
      userName(instance.userName());
      @Nullable String currentPasswordValue = instance.currentPassword();
      if (currentPasswordValue != null) {
        currentPassword(currentPasswordValue);
      }
      newPassword(instance.newPassword());
      return this;
    }

    /**
     * Initializes the value for the {@link PasswordResetRequest#userName() userName} attribute.
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
     * Initializes the value for the {@link PasswordResetRequest#currentPassword() currentPassword} attribute.
     * @param currentPassword The value for currentPassword (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("currentPassword")
    public final Builder currentPassword(@Nullable String currentPassword) {
      this.currentPassword = currentPassword;
      return this;
    }

    /**
     * Initializes the value for the {@link PasswordResetRequest#newPassword() newPassword} attribute.
     * @param newPassword The value for newPassword 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("newPassword")
    public final Builder newPassword(String newPassword) {
      this.newPassword = Objects.requireNonNull(newPassword, "newPassword");
      initBits &= ~INIT_BIT_NEW_PASSWORD;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePasswordResetRequest ImmutablePasswordResetRequest}.
     * @return An immutable instance of PasswordResetRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePasswordResetRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePasswordResetRequest(userName, currentPassword, newPassword);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_USER_NAME) != 0) attributes.add("userName");
      if ((initBits & INIT_BIT_NEW_PASSWORD) != 0) attributes.add("newPassword");
      return "Cannot build PasswordResetRequest, some of required attributes are not set " + attributes;
    }
  }
}
