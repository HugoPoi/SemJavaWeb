//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.07.07 à 10:25:25 PM CEST 
//


package dev.leanforge.tutorialschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meta">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="software">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="website">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="languages">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codinglang" type="{}codinglang" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="plateforms" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="categories">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="category" type="{}leancategory" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="content" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="step" maxOccurs="20">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="substep" maxOccurs="20">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="img" type="{}img" minOccurs="0"/>
 *                                       &lt;element name="video" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                                               &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="btn" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                                               &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="multiimg" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="slider" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}language" default="fr-FR" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "meta",
    "content"
})
@XmlRootElement(name = "tutorial")
public class Tutorial {

    @XmlElement(required = true)
    protected Tutorial.Meta meta;
    @XmlElement(required = true)
    protected List<Tutorial.Content> content;

    /**
     * Obtient la valeur de la propriété meta.
     * 
     * @return
     *     possible object is
     *     {@link Tutorial.Meta }
     *     
     */
    public Tutorial.Meta getMeta() {
        return meta;
    }

    /**
     * Définit la valeur de la propriété meta.
     * 
     * @param value
     *     allowed object is
     *     {@link Tutorial.Meta }
     *     
     */
    public void setMeta(Tutorial.Meta value) {
        this.meta = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tutorial.Content }
     * 
     * 
     */
    public List<Tutorial.Content> getContent() {
        if (content == null) {
            content = new ArrayList<Tutorial.Content>();
        }
        return this.content;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="step" maxOccurs="20">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="substep" maxOccurs="20">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="img" type="{}img" minOccurs="0"/>
     *                             &lt;element name="video" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *                                     &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="btn" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *                                     &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="multiimg" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="slider" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="lang" type="{http://www.w3.org/2001/XMLSchema}language" default="fr-FR" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "title",
        "step"
    })
    public static class Content {

        @XmlElement(required = true)
        protected String title;
        @XmlElement(required = true)
        protected List<Tutorial.Content.Step> step;
        @XmlAttribute(name = "lang")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "language")
        protected String lang;

        /**
         * Obtient la valeur de la propriété title.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Définit la valeur de la propriété title.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the step property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the step property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStep().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Tutorial.Content.Step }
         * 
         * 
         */
        public List<Tutorial.Content.Step> getStep() {
            if (step == null) {
                step = new ArrayList<Tutorial.Content.Step>();
            }
            return this.step;
        }

        /**
         * Obtient la valeur de la propriété lang.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLang() {
            if (lang == null) {
                return "fr-FR";
            } else {
                return lang;
            }
        }

        /**
         * Définit la valeur de la propriété lang.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLang(String value) {
            this.lang = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="substep" maxOccurs="20">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="img" type="{}img" minOccurs="0"/>
         *                   &lt;element name="video" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *                           &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="btn" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *                           &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="multiimg" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="slider" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "substep"
        })
        public static class Step {

            @XmlElement(required = true)
            protected List<Tutorial.Content.Step.Substep> substep;
            @XmlAttribute(name = "name", required = true)
            protected String name;

            /**
             * Gets the value of the substep property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the substep property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSubstep().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Tutorial.Content.Step.Substep }
             * 
             * 
             */
            public List<Tutorial.Content.Step.Substep> getSubstep() {
                if (substep == null) {
                    substep = new ArrayList<Tutorial.Content.Step.Substep>();
                }
                return this.substep;
            }

            /**
             * Obtient la valeur de la propriété name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Définit la valeur de la propriété name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="img" type="{}img" minOccurs="0"/>
             *         &lt;element name="video" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
             *                 &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="btn" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
             *                 &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="multiimg" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="slider" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "text",
                "code",
                "img",
                "video",
                "btn",
                "multiimg",
                "slider"
            })
            public static class Substep {

                protected String text;
                protected String code;
                protected Img img;
                protected Tutorial.Content.Step.Substep.Video video;
                protected Tutorial.Content.Step.Substep.Btn btn;
                protected Tutorial.Content.Step.Substep.Multiimg multiimg;
                protected Tutorial.Content.Step.Substep.Slider slider;

                /**
                 * Obtient la valeur de la propriété text.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Définit la valeur de la propriété text.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

                /**
                 * Obtient la valeur de la propriété code.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCode() {
                    return code;
                }

                /**
                 * Définit la valeur de la propriété code.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCode(String value) {
                    this.code = value;
                }

                /**
                 * Obtient la valeur de la propriété img.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Img }
                 *     
                 */
                public Img getImg() {
                    return img;
                }

                /**
                 * Définit la valeur de la propriété img.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Img }
                 *     
                 */
                public void setImg(Img value) {
                    this.img = value;
                }

                /**
                 * Obtient la valeur de la propriété video.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Tutorial.Content.Step.Substep.Video }
                 *     
                 */
                public Tutorial.Content.Step.Substep.Video getVideo() {
                    return video;
                }

                /**
                 * Définit la valeur de la propriété video.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Tutorial.Content.Step.Substep.Video }
                 *     
                 */
                public void setVideo(Tutorial.Content.Step.Substep.Video value) {
                    this.video = value;
                }

                /**
                 * Obtient la valeur de la propriété btn.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Tutorial.Content.Step.Substep.Btn }
                 *     
                 */
                public Tutorial.Content.Step.Substep.Btn getBtn() {
                    return btn;
                }

                /**
                 * Définit la valeur de la propriété btn.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Tutorial.Content.Step.Substep.Btn }
                 *     
                 */
                public void setBtn(Tutorial.Content.Step.Substep.Btn value) {
                    this.btn = value;
                }

                /**
                 * Obtient la valeur de la propriété multiimg.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Tutorial.Content.Step.Substep.Multiimg }
                 *     
                 */
                public Tutorial.Content.Step.Substep.Multiimg getMultiimg() {
                    return multiimg;
                }

                /**
                 * Définit la valeur de la propriété multiimg.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Tutorial.Content.Step.Substep.Multiimg }
                 *     
                 */
                public void setMultiimg(Tutorial.Content.Step.Substep.Multiimg value) {
                    this.multiimg = value;
                }

                /**
                 * Obtient la valeur de la propriété slider.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Tutorial.Content.Step.Substep.Slider }
                 *     
                 */
                public Tutorial.Content.Step.Substep.Slider getSlider() {
                    return slider;
                }

                /**
                 * Définit la valeur de la propriété slider.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Tutorial.Content.Step.Substep.Slider }
                 *     
                 */
                public void setSlider(Tutorial.Content.Step.Substep.Slider value) {
                    this.slider = value;
                }


                /**
                 * <p>Classe Java pour anonymous complex type.
                 * 
                 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
                 *       &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Btn {

                    @XmlAttribute(name = "href", required = true)
                    @XmlSchemaType(name = "anyURI")
                    protected String href;
                    @XmlAttribute(name = "title", required = true)
                    protected String title;
                    @XmlAttribute(name = "alt", required = true)
                    protected String alt;

                    /**
                     * Obtient la valeur de la propriété href.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getHref() {
                        return href;
                    }

                    /**
                     * Définit la valeur de la propriété href.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setHref(String value) {
                        this.href = value;
                    }

                    /**
                     * Obtient la valeur de la propriété title.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTitle() {
                        return title;
                    }

                    /**
                     * Définit la valeur de la propriété title.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTitle(String value) {
                        this.title = value;
                    }

                    /**
                     * Obtient la valeur de la propriété alt.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAlt() {
                        return alt;
                    }

                    /**
                     * Définit la valeur de la propriété alt.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAlt(String value) {
                        this.alt = value;
                    }

                }


                /**
                 * <p>Classe Java pour anonymous complex type.
                 * 
                 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "img"
                })
                public static class Multiimg {

                    @XmlElement(required = true)
                    protected List<Img> img;

                    /**
                     * Gets the value of the img property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the img property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getImg().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Img }
                     * 
                     * 
                     */
                    public List<Img> getImg() {
                        if (img == null) {
                            img = new ArrayList<Img>();
                        }
                        return this.img;
                    }

                }


                /**
                 * <p>Classe Java pour anonymous complex type.
                 * 
                 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="img" type="{}img" maxOccurs="unbounded" minOccurs="2"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "img"
                })
                public static class Slider {

                    @XmlElement(required = true)
                    protected List<Img> img;

                    /**
                     * Gets the value of the img property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the img property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getImg().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Img }
                     * 
                     * 
                     */
                    public List<Img> getImg() {
                        if (img == null) {
                            img = new ArrayList<Img>();
                        }
                        return this.img;
                    }

                }


                /**
                 * <p>Classe Java pour anonymous complex type.
                 * 
                 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="src" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
                 *       &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="alt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Video {

                    @XmlAttribute(name = "src", required = true)
                    @XmlSchemaType(name = "anyURI")
                    protected String src;
                    @XmlAttribute(name = "title", required = true)
                    protected String title;
                    @XmlAttribute(name = "alt", required = true)
                    protected String alt;

                    /**
                     * Obtient la valeur de la propriété src.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSrc() {
                        return src;
                    }

                    /**
                     * Définit la valeur de la propriété src.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSrc(String value) {
                        this.src = value;
                    }

                    /**
                     * Obtient la valeur de la propriété title.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTitle() {
                        return title;
                    }

                    /**
                     * Définit la valeur de la propriété title.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTitle(String value) {
                        this.title = value;
                    }

                    /**
                     * Obtient la valeur de la propriété alt.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAlt() {
                        return alt;
                    }

                    /**
                     * Définit la valeur de la propriété alt.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAlt(String value) {
                        this.alt = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="software">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="website">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="languages">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codinglang" type="{}codinglang" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="plateforms" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="categories">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="category" type="{}leancategory" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "software",
        "languages",
        "plateforms",
        "categories",
        "keywords"
    })
    public static class Meta {

        @XmlElement(required = true)
        protected Tutorial.Meta.Software software;
        @XmlElement(required = true)
        protected Tutorial.Meta.Languages languages;
        @XmlElement(required = true)
        protected String plateforms;
        @XmlElement(required = true)
        protected Tutorial.Meta.Categories categories;
        @XmlElement(required = true)
        protected String keywords;

        /**
         * Obtient la valeur de la propriété software.
         * 
         * @return
         *     possible object is
         *     {@link Tutorial.Meta.Software }
         *     
         */
        public Tutorial.Meta.Software getSoftware() {
            return software;
        }

        /**
         * Définit la valeur de la propriété software.
         * 
         * @param value
         *     allowed object is
         *     {@link Tutorial.Meta.Software }
         *     
         */
        public void setSoftware(Tutorial.Meta.Software value) {
            this.software = value;
        }

        /**
         * Obtient la valeur de la propriété languages.
         * 
         * @return
         *     possible object is
         *     {@link Tutorial.Meta.Languages }
         *     
         */
        public Tutorial.Meta.Languages getLanguages() {
            return languages;
        }

        /**
         * Définit la valeur de la propriété languages.
         * 
         * @param value
         *     allowed object is
         *     {@link Tutorial.Meta.Languages }
         *     
         */
        public void setLanguages(Tutorial.Meta.Languages value) {
            this.languages = value;
        }

        /**
         * Obtient la valeur de la propriété plateforms.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlateforms() {
            return plateforms;
        }

        /**
         * Définit la valeur de la propriété plateforms.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlateforms(String value) {
            this.plateforms = value;
        }

        /**
         * Obtient la valeur de la propriété categories.
         * 
         * @return
         *     possible object is
         *     {@link Tutorial.Meta.Categories }
         *     
         */
        public Tutorial.Meta.Categories getCategories() {
            return categories;
        }

        /**
         * Définit la valeur de la propriété categories.
         * 
         * @param value
         *     allowed object is
         *     {@link Tutorial.Meta.Categories }
         *     
         */
        public void setCategories(Tutorial.Meta.Categories value) {
            this.categories = value;
        }

        /**
         * Obtient la valeur de la propriété keywords.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKeywords() {
            return keywords;
        }

        /**
         * Définit la valeur de la propriété keywords.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKeywords(String value) {
            this.keywords = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="category" type="{}leancategory" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "category"
        })
        public static class Categories {

            @XmlElement(required = true)
            protected List<Leancategory> category;

            /**
             * Gets the value of the category property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the category property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCategory().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Leancategory }
             * 
             * 
             */
            public List<Leancategory> getCategory() {
                if (category == null) {
                    category = new ArrayList<Leancategory>();
                }
                return this.category;
            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="codinglang" type="{}codinglang" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codinglang"
        })
        public static class Languages {

            @XmlElement(required = true)
            protected List<String> codinglang;

            /**
             * Gets the value of the codinglang property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the codinglang property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCodinglang().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getCodinglang() {
                if (codinglang == null) {
                    codinglang = new ArrayList<String>();
                }
                return this.codinglang;
            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="website">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name",
            "website"
        })
        public static class Software {

            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected Tutorial.Meta.Software.Website website;
            @XmlAttribute(name = "id", required = true)
            protected String id;

            /**
             * Obtient la valeur de la propriété name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Définit la valeur de la propriété name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obtient la valeur de la propriété website.
             * 
             * @return
             *     possible object is
             *     {@link Tutorial.Meta.Software.Website }
             *     
             */
            public Tutorial.Meta.Software.Website getWebsite() {
                return website;
            }

            /**
             * Définit la valeur de la propriété website.
             * 
             * @param value
             *     allowed object is
             *     {@link Tutorial.Meta.Software.Website }
             *     
             */
            public void setWebsite(Tutorial.Meta.Software.Website value) {
                this.website = value;
            }

            /**
             * Obtient la valeur de la propriété id.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getId() {
                return id;
            }

            /**
             * Définit la valeur de la propriété id.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setId(String value) {
                this.id = value;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Website {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "href", required = true)
                @XmlSchemaType(name = "anyURI")
                protected String href;

                /**
                 * Obtient la valeur de la propriété value.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Définit la valeur de la propriété value.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Obtient la valeur de la propriété href.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHref() {
                    return href;
                }

                /**
                 * Définit la valeur de la propriété href.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHref(String value) {
                    this.href = value;
                }

            }

        }

    }

}
