/*******************************************************************************
 * Copyright (c) 2019 Microsoft Research. All rights reserved. 
 *
 * The MIT License (MIT)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software. 
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN
 * AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *   Markus Alexander Kuppe - initial API and implementation
 ******************************************************************************/
package tlc2.overrides;

// tlc2.tool.impl.SpecProcessor's "api" only loads class
// "tlc2.overrides.TLCOverrides".
public class TLCOverrides implements ITLCOverrides {

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] get() {
		try {
                        // Remove `Json.resolves();` call when this Class is moved to `TLC`.
			Json.resolves();
			return new Class[] { TLCExt.class, IOUtils.class, SVG.class, SequencesExt.class, Json.class, Bitwise.class,
					FiniteSetsExt.class, Functions.class, CSV.class };
		} catch (NoClassDefFoundError e) {
                        // Remove this catch when this Class is moved to `TLC`.
			System.out.println(
					"gson dependencies of Json overrides not found, Json module won't work unless "
					+ "the libraries in the lib/ folder of the CommunityModules have been added to the classpath of TLC.");
		}
		return new Class[] { TLCExt.class, IOUtils.class, SVG.class, SequencesExt.class, Bitwise.class,
				FiniteSetsExt.class, Functions.class, CSV.class };
	}
}
