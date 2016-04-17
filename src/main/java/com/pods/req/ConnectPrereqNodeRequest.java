package com.pods.req;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ConnectPrereqNodeRequest {
    private Set<UUID> prereqs = new HashSet<>();

    public ConnectPrereqNodeRequest(Set<UUID> prereqs) {
        this.prereqs = prereqs;
    }

    public Set<UUID> getPrereqs() {
        return prereqs;
    }
}
