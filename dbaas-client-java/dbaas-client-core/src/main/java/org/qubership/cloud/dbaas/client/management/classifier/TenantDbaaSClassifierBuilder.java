package org.qubership.cloud.dbaas.client.management.classifier;

import org.qubership.cloud.framework.contexts.tenant.TenantContextObject;
import org.qubership.cloud.context.propagation.core.ContextManager;
import org.qubership.cloud.dbaas.client.management.DbaasDbClassifier;


import static org.qubership.cloud.dbaas.client.DbaasConst.*;


public class TenantDbaaSClassifierBuilder extends DbaaSChainClassifierBuilder {

    public TenantDbaaSClassifierBuilder(DbaaSChainClassifierBuilder next) {
        super(next);
    }

    public TenantDbaaSClassifierBuilder() {
        this(null);
    }

    @Override
    public DbaasDbClassifier build() {
        return new DbaasDbClassifier.Builder()
                .withProperties(super.build().asMap())
                .withProperty(TENANT_ID, ((TenantContextObject) ContextManager.get("tenant")).getTenant())
                .withProperty(SCOPE, TENANT)
                .build();
    }
}
