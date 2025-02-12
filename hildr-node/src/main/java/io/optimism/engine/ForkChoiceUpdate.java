/*
 * Copyright 2023 281165273grape@gmail.com
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

package io.optimism.engine;

import io.optimism.engine.ExecutionPayload.PayloadStatus;
import java.math.BigInteger;
import org.web3j.utils.Numeric;

/**
 * The type ForkChoiceUpdate.
 *
 * <p>payloadStatus Payload status. Note: values of the status field in the context of this method
 * are restricted to the following subset: VALID, INVALID, SYNCING. payloadId 8 byte identifier of
 * the payload build process or null
 *
 * @param payloadStatus Payload status. Note: values of the status field in the context of this
 * @param payloadId 8 byte identifier of the payload build process or null
 * @author zhouop0
 * @since 0.1.0
 */
public record ForkChoiceUpdate(PayloadStatus payloadStatus, BigInteger payloadId) {

    /**
     * The type Fork choice update res.
     *
     * @param payloadStatus Payload status. Note: values of the status field in the context of this
     * @param payloadId 8 byte identifier of the payload build process or null
     */
    public record ForkChoiceUpdateRes(PayloadStatus payloadStatus, String payloadId) {

        /**
         * To fork choice update fork choice update.
         *
         * @return the fork choice update
         */
        public ForkChoiceUpdate toForkChoiceUpdate() {
            return new ForkChoiceUpdate(payloadStatus, payloadId != null ? Numeric.decodeQuantity(payloadId) : null);
        }
    }

    /**
     * the type ForkchoiceState.
     *
     * @param headBlockHash 32 byte block hash of the head of the canonical chain
     * @param safeBlockHash 32 byte "safe" block hash of the canonical chain under certain synchrony
     *     and honesty assumptions This value MUST be either equal to or an ancestor of headBlockHash
     * @param finalizedBlockHash 32 byte block hash of the most recent finalized block.
     * @author zhouop0
     * @since 0.1.0
     */
    public record ForkchoiceState(String headBlockHash, String safeBlockHash, String finalizedBlockHash) {

        /**
         * From single head forkchoice state.
         *
         * @param headBlockHash the head block hash
         * @return the forkchoice state
         */
        public static ForkchoiceState fromSingleHead(String headBlockHash) {
            return new ForkchoiceState(headBlockHash, headBlockHash, headBlockHash);
        }
    }
}
