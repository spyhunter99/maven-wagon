package org.apache.maven.wagon.repository;

/* ====================================================================
 *   Copyright 2001-2004 The Apache Software Foundation.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * ====================================================================
 */

import junit.framework.TestCase;
import org.apache.maven.wagon.WagonConstants;
import org.apache.maven.wagon.authentication.AuthenticationInfo;
import org.apache.maven.wagon.proxy.ProxyInfo;

/**
 * @author <a href="mailto:jvanzyl@maven.org">Jason van Zyl</a>
 * @version $Id$
 */
public class RepositoryTest
        extends TestCase
{
    public RepositoryTest( final String name )
    {
        super( name );
    }

    public void setUp()
            throws Exception
    {
        super.setUp();
    }

    public void tearDown()
            throws Exception
    {
        super.tearDown();
    }

    public void testRepositoryProperties()
            throws Exception
    {
        Repository repository = new Repository();

        repository.setAuthenticationInfo( new AuthenticationInfo() );

        assertNotNull( repository.getAuthenticationInfo() );

        repository.setProxyInfo( new ProxyInfo() );

        assertNotNull( repository.getProxyInfo() );

        repository.setBasedir( "directory" );

        assertEquals( "directory", repository.getBasedir() );

        repository.setName( "name" );

        assertEquals( "name", repository.getName() );

        repository.setPort( 0 );

        assertEquals( 0, repository.getPort() );

        assertEquals( "localhost", repository.getHost() );

        repository.setUrl( "http://www.ibiblio.org" );

        assertEquals( "http", repository.getProtocol() );

        assertEquals( "www.ibiblio.org", repository.getHost() );

        assertEquals( "", repository.getBasedir() );

        assertEquals( WagonConstants.UNKNOWN_PORT, repository.getPort() );

        repository.setUrl( "https://www.ibiblio.org:100/maven" );

        assertEquals( "https://www.ibiblio.org:100/maven", repository.getUrl() );

        assertEquals( "https", repository.getProtocol() );

        assertEquals( "www.ibiblio.org", repository.getHost() );

        assertEquals( "maven", repository.getBasedir() );

        assertEquals( 100, repository.getPort() );

        assertEquals( "www.ibiblio.org", repository.getHost() );

        repository.setBasedir( "basedir" );

        assertEquals( "basedir", repository.getBasedir() );
    }
}