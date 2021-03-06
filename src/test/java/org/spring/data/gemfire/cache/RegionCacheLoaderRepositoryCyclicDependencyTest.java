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

import javax.annotation.Resource;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.cache.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.data.gemfire.AbstractGemFireIntegrationTest;
import org.spring.data.gemfire.app.beans.User;
import org.spring.data.gemfire.app.dao.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The RegionCacheLoaderRepositoryCyclicDependencyTest class...
 * <p/>
 *
 * @author John Blum
 * @see
 * @since 7.x
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@SuppressWarnings("unused")
public class RegionCacheLoaderRepositoryCyclicDependencyTest extends AbstractGemFireIntegrationTest {

	@Resource(name = "Users")
	private Region<String, User> users;

	@Test
	public void usersRegion() {
		assertRegion(users, "Users");
	}

	public static class UsersCacheLoader implements CacheLoader {

		@Autowired
		private UserRepository userRepository;

		@Override
		public Object load(final LoaderHelper helper) throws CacheLoaderException {
			return userRepository.findById(String.valueOf(helper.getKey())).orElse(null);
		}

		@Override
		public void close() {
		}
	}
}
