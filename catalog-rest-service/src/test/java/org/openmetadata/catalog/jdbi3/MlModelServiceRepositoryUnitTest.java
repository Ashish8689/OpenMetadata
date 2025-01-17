/*
 *  Copyright 2022 Collate
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openmetadata.catalog.jdbi3;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.openmetadata.catalog.api.services.CreateMlModelService.MlModelServiceType.Mlflow;

import org.openmetadata.catalog.entity.services.MlModelService;
import org.openmetadata.catalog.entity.services.ServiceType;
import org.openmetadata.catalog.secrets.SecretsManager;
import org.openmetadata.catalog.services.connections.database.MysqlConnection;
import org.openmetadata.catalog.type.MlModelConnection;

public class MlModelServiceRepositoryUnitTest
    extends ServiceEntityRepositoryTest<MlModelServiceRepository, MlModelService, MlModelConnection> {

  protected MlModelServiceRepositoryUnitTest() {
    super(ServiceType.ML_MODEL);
  }

  @Override
  protected MlModelServiceRepository newServiceRepository(CollectionDAO collectionDAO, SecretsManager secretsManager) {
    return new MlModelServiceRepository(collectionDAO, secretsManager);
  }

  @Override
  protected void mockServiceResourceSpecific() {
    service = mock(MlModelService.class);
    serviceConnection = mock(MlModelConnection.class);
    when(serviceConnection.getConfig()).thenReturn(mock(MysqlConnection.class));
    CollectionDAO.MlModelServiceDAO entityDAO = mock(CollectionDAO.MlModelServiceDAO.class);
    when(collectionDAO.mlModelServiceDAO()).thenReturn(entityDAO);
    when(entityDAO.getEntityClass()).thenReturn(MlModelService.class);
    when(service.withHref(isNull())).thenReturn(service);
    when(service.withOwner(isNull())).thenReturn(service);
    when(service.getConnection()).thenReturn(serviceConnection);
    when(service.getServiceType()).thenReturn(Mlflow);
  }
}
