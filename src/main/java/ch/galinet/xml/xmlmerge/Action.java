/*
 * EL4J, the Extension Library for the J2EE, adds incremental enhancements to
 * the spring framework, http://el4j.sf.net
 * Copyright (C) 2006 by ELCA Informatique SA, Av. de la Harpe 22-24,
 * 1000 Lausanne, Switzerland, http://www.elca.ch
 *
 * EL4J is published under the GNU Lesser General Public License (LGPL)
 * Version 2.1. See http://www.gnu.org/licenses/
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * For alternative licensing, please contact info@elca.ch
 */
package ch.galinet.xml.xmlmerge;

import org.jdom.Element;

/**
 * Operation on two nodes creating a third node.
 *
 * @svnLink $Revision$;$Date$;$Author$;$URL$
 *
 * @author Laurent Bovet (LBO)
 * @author Alex Mathey (AMA)
 */
public interface Action extends Operation {

	/**
	 * Out of an original element and a second element provided by the patch
	 * DOM, applies an operation and modifies the parent node of the result DOM.
	 *
	 * @param originalElement Original element
	 * @param patchElement Patch element
	 * @param outputParentElement Output parent element
	 */
	void perform(Element originalElement, Element patchElement,
		Element outputParentElement) throws AbstractXmlMergeException;

}
