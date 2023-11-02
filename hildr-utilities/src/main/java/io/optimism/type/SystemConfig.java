/*
 * Copyright 2023 q315xia@163.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.optimism.type;

import java.math.BigInteger;

/**
 * The system config.
 *
 * @param batcherAddr batcher address
 * @param overhead overhead
 * @param scalar scalar
 * @param gasLimit gas limit
 * @author thinkAfCod
 * @since 0.1.1
 */
public record SystemConfig(
    String batcherAddr, BigInteger overhead, BigInteger scalar, BigInteger gasLimit) {}