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
package ch.galinet.xml.xmlmerge.config;

import java.io.InputStream;

import ch.galinet.xml.xmlmerge.merge.DefaultXmlMerge;
import org.w3c.dom.Document;

import ch.galinet.xml.xmlmerge.AbstractXmlMergeException;
import ch.galinet.xml.xmlmerge.ConfigurationException;
import ch.galinet.xml.xmlmerge.Configurer;
import ch.galinet.xml.xmlmerge.Mapper;
import ch.galinet.xml.xmlmerge.MergeAction;
import ch.galinet.xml.xmlmerge.XmlMerge;

/**
 * XmlMerge wrapper applying a configurer on the wrapped instance.
 *
 * @svnLink $Revision$;$Date$;$Author$;$URL$
 *
 * @author Laurent Bovet (LBO)
 * @author Alex Mathey (AMA)
 */
public class ConfigurableXmlMerge implements XmlMerge {

	/**
	 * Wrapped XmlMerge instance.
	 */
	XmlMerge m_wrappedXmlMerge;
	
	/**
	 * Creates a default XmlMerge instance and configures it with the given
	 * configurer.
	 *
	 * @param configurer
	 *            The configurer used to configure the XmlMerge instance
	 * @throws ConfigurationException
	 *             If an error occurred during configuration
	 */
	public ConfigurableXmlMerge(Configurer configurer)
		throws ConfigurationException {
		this(new DefaultXmlMerge(), configurer);
	}
	
	/**
	 * Applies a configurer on a wrapped XmlMerge instance.
	 *
	 * @param wrappedXmlMerge
	 *            The wrapped XmlMerge instance to configure
	 * @param configurer
	 *            The configurer to apply
	 * @throws ConfigurationException
	 *             If an error occurred during configuration
	 */
	public ConfigurableXmlMerge(XmlMerge wrappedXmlMerge, Configurer configurer)
		throws ConfigurationException {
		this.m_wrappedXmlMerge = wrappedXmlMerge;
		configurer.configure(wrappedXmlMerge);
	}

	/**
	 * {@inheritDoc}
	 */
	public InputStream merge(InputStream[] sources) throws AbstractXmlMergeException {
		return m_wrappedXmlMerge.merge(sources);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Document merge(Document[] sources) throws AbstractXmlMergeException {
		return m_wrappedXmlMerge.merge(sources);
	}

	/**
	 * {@inheritDoc}
	 */
	public String merge(String[] sources) throws AbstractXmlMergeException {
		return m_wrappedXmlMerge.merge(sources);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRootMapper(Mapper rootMapper) {
		m_wrappedXmlMerge.setRootMapper(rootMapper);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRootMergeAction(MergeAction rootMergeAction) {
		m_wrappedXmlMerge.setRootMergeAction(rootMergeAction);
	}
	
}
