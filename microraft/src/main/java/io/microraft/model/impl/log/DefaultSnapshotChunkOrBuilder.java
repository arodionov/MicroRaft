/*
 * Copyright (c) 2020, MicroRaft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.microraft.model.impl.log;

import io.microraft.RaftEndpoint;
import io.microraft.model.log.SnapshotChunk;

import javax.annotation.Nonnull;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

/**
 * @author metanet
 */
public class DefaultSnapshotChunkOrBuilder
        implements SnapshotChunk, SnapshotChunk.SnapshotChunkBuilder {

    private int term;
    private long index;
    private Object operation;
    private int snapshotChunkIndex;
    private int snapshotChunkCount;
    private long groupMembersLogIndex;
    private Collection<RaftEndpoint> groupMembers;
    private DefaultSnapshotChunkOrBuilder builder = this;

    @Override
    public long getIndex() {
        return index;
    }

    @Override
    public int getTerm() {
        return term;
    }

    @Nonnull
    @Override
    public Object getOperation() {
        return operation;
    }

    @Override
    public int getSnapshotChunkIndex() {
        return snapshotChunkIndex;
    }

    @Override
    public int getSnapshotChunkCount() {
        return snapshotChunkCount;
    }

    @Override
    public long getGroupMembersLogIndex() {
        return groupMembersLogIndex;
    }

    @Nonnull
    @Override
    public Collection<RaftEndpoint> getGroupMembers() {
        return groupMembers;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setIndex(long index) {
        builder.index = index;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setTerm(int term) {
        builder.term = term;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setOperation(@Nonnull Object operation) {
        builder.operation = operation;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setSnapshotChunkIndex(int snapshotChunkIndex) {
        builder.snapshotChunkIndex = snapshotChunkIndex;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setSnapshotChunkCount(int snapshotChunkCount) {
        builder.snapshotChunkCount = snapshotChunkCount;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setGroupMembersLogIndex(long groupMembersLogIndex) {
        builder.groupMembersLogIndex = groupMembersLogIndex;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunkBuilder setGroupMembers(@Nonnull Collection<RaftEndpoint> groupMembers) {
        builder.groupMembers = groupMembers;
        return this;
    }

    @Nonnull
    @Override
    public SnapshotChunk build() {
        requireNonNull(builder);
        builder = null;
        return this;
    }

    @Override
    public String toString() {
        String header = builder != null ? "SnapshotChunkBuilder" : "SnapshotChunk";
        return header + "{" + "term=" + term + ", index=" + index + ", operation=" + operation + ", chunkIndex="
                + snapshotChunkIndex + ", chunkCount=" + snapshotChunkCount + ", groupMembersLogIndex=" + groupMembersLogIndex
                + ", groupMembers=" + groupMembers + '}';
    }

}