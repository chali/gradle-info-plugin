/*
 * Copyright 2016-2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nebula.plugin.info.ci

import org.gradle.api.Project
import org.gradle.api.provider.ProviderFactory

class TravisProvider extends AbstractContinuousIntegrationProvider {
    TravisProvider(ProviderFactory providerFactory) {
        super(providerFactory)
    }

    @Override
    boolean supports(Project project) {
        getEnvironmentVariable('TRAVIS')
    }

    @Override
    String calculateHost(Project project) {
        return hostname()
    }

    @Override
    String calculateJob(Project project) {
        getEnvironmentVariable("TRAVIS_REPO_SLUG")
    }

    @Override
    String calculateBuildNumber(Project project) {
        getEnvironmentVariable("TRAVIS_BUILD_NUMBER")
    }

    @Override
    String calculateBuildId(Project project) {
        getEnvironmentVariable("TRAVIS_BUILD_ID")
    }
}
