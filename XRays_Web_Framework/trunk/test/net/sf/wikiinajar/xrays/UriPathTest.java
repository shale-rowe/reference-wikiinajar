/*
 * XRays Web Framework
 * 
 * Copyright (C) 2007 rico_g AT users DOT sourceforge DOT net
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License s published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 * 
 */

package net.sf.wikiinajar.xrays;

import net.sf.wikiinajar.xrays.HttpServer;
import net.sf.wikiinajar.xrays.HttpServer.UriPath;
import junit.framework.TestCase;

public class UriPathTest extends TestCase {

	public void testGetController() {
		
		UriPath fixture = new HttpServer.UriPath("/test/show/id");
		assertEquals("test", fixture.getController());
		
		fixture = new HttpServer.UriPath("/test");
		assertEquals("test", fixture.getController());
		
		fixture = new HttpServer.UriPath("/");
		assertNull(fixture.getController());
		
		fixture = new HttpServer.UriPath("");
		assertNull(fixture.getController());
	}
	
	public void testGetAction() {
		UriPath fixture = new HttpServer.UriPath("/test/action/id");
		assertEquals("action", fixture.getAction());
		
		fixture = new HttpServer.UriPath("/test/");
		assertEquals(UriPath.DEFAULT_ACTION, fixture.getAction());
		
		fixture = new HttpServer.UriPath("/test");
		assertEquals(UriPath.DEFAULT_ACTION, fixture.getAction());
		
		fixture = new HttpServer.UriPath("");
		assertEquals(UriPath.DEFAULT_ACTION, fixture.getAction());
	}
	
	public void testGetIds() {
		UriPath fixture = new HttpServer.UriPath("/test/action/id");
		assertEquals("id", fixture.getIds());
		
		fixture = new HttpServer.UriPath("/test/action/id/file/text.txt");
		assertEquals("id/file/text.txt", fixture.getIds());
		
		fixture = new HttpServer.UriPath("/test/action/");
		assertNull(fixture.getIds());
	}
	
	public void testGetIdsAsList() {
		
		UriPath fixture = new HttpServer.UriPath("/test/action/id");
		assertEquals("[id]", fixture.getIdsAsList().toString());
		
		fixture = new HttpServer.UriPath("/test/action/id/file/text.txt");
		assertEquals("[id, file, text.txt]", fixture.getIdsAsList().toString());
		
		fixture = new HttpServer.UriPath("/test/action/");
		assertEquals("[]", fixture.getIdsAsList().toString());
	}

}
