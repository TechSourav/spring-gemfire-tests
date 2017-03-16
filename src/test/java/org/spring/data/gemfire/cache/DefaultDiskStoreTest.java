/*
 * Copyright 2014-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.spring.data.gemfire.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.geode.cache.DiskStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The DefaultDiskStoreTest class is a test suite of test cases testing the contract and functionality of SDG's
 * configuration and use of the GemFire "DEFAULT" DiskStore.
 *
 * @author John Blum
 * @see org.junit.Test
 * @see org.junit.runner.RunWith
 * @see org.springframework.test.context.ContextConfiguration
 * @see org.springframework.test.context.junit4.SpringJUnit4ClassRunner
 * @see org.apache.geode.cache.DiskStore
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SuppressWarnings("unused")
public class DefaultDiskStoreTest {

  @Autowired
  private DiskStore defaultDiskStore;

  @Test
  public void testDefaultDiskStoreConfiguration() {
    assertNotNull("The 'DEFAULT' DiskStore was not properly configured and initialized!", defaultDiskStore);
    assertEquals("DEFAULT", defaultDiskStore.getName());
    assertTrue(defaultDiskStore.getAllowForceCompaction());
    assertTrue(defaultDiskStore.getAutoCompact());
    assertEquals(75, defaultDiskStore.getCompactionThreshold());
    assertEquals(50, defaultDiskStore.getQueueSize());
    assertEquals(10, defaultDiskStore.getMaxOplogSize());
    assertEquals(60000, defaultDiskStore.getTimeInterval());
    assertEquals(16384, defaultDiskStore.getWriteBufferSize());
  }

}
