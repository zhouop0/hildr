/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package io.optimism.rpc.internal.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The enum Json rpc error. */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@SuppressWarnings("ImmutableEnumChecker")
public enum JsonRpcError {
    /** The Parse error. */
    // Standard errors
    PARSE_ERROR(-32700, "Parse error"),
    /** The Invalid request. */
    INVALID_REQUEST(-32600, "Invalid Request"),
    /** The Method not found. */
    METHOD_NOT_FOUND(-32601, "Method not found"),
    /** The Invalid params. */
    INVALID_PARAMS(-32602, "Invalid params"),
    /** The Internal error. */
    INTERNAL_ERROR(-32603, "Internal error"),
    /** The Timeout error. */
    TIMEOUT_ERROR(-32603, "Timeout expired"),

    /** Unauthorized json rpc error. */
    UNAUTHORIZED(-40100, "Unauthorized"),
    /** The Method not enabled. */
    METHOD_NOT_ENABLED(-32604, "Method not enabled");

    private final int code;
    private final String message;
    private String data;

    JsonRpcError(final int code, final String message, final String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    JsonRpcError(final int code, final String message) {
        this(code, message, null);
    }

    /**
     * get error code.
     *
     * @return error code
     */
    @JsonGetter("code")
    public int getCode() {
        return code;
    }

    /**
     * get error message
     *
     * @return error message
     */
    @JsonGetter("message")
    public String getMessage() {
        return message;
    }

    /**
     * get error data
     *
     * @return error data
     */
    @JsonGetter("data")
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * From json json rpc error.
     *
     * @param code the code
     * @param message the message
     * @param data the data
     * @return the json rpc error
     */
    @JsonCreator
    public static JsonRpcError fromJson(
            @JsonProperty("code") final int code,
            @JsonProperty("message") final String message,
            @JsonProperty("data") final String data) {
        for (final JsonRpcError error : JsonRpcError.values()) {
            if (error.code == code && error.message.equals(message) && error.data.equals(data)) {
                return error;
            }
        }
        return null;
    }
}
