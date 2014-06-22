//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.06.22 à 08:33:33 PM CEST 
//


package dev.leanforge.tutorialschema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour leancategory.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="leancategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="testing"/>
 *     &lt;enumeration value="coding-environnement"/>
 *     &lt;enumeration value="build"/>
 *     &lt;enumeration value="manage-project"/>
 *     &lt;enumeration value="manage-sources"/>
 *     &lt;enumeration value="manage-client"/>
 *     &lt;enumeration value="specification-architecture"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "leancategory")
@XmlEnum
public enum Leancategory {

    @XmlEnumValue("testing")
    TESTING("testing"),
    @XmlEnumValue("coding-environnement")
    CODING_ENVIRONNEMENT("coding-environnement"),
    @XmlEnumValue("build")
    BUILD("build"),
    @XmlEnumValue("manage-project")
    MANAGE_PROJECT("manage-project"),
    @XmlEnumValue("manage-sources")
    MANAGE_SOURCES("manage-sources"),
    @XmlEnumValue("manage-client")
    MANAGE_CLIENT("manage-client"),
    @XmlEnumValue("specification-architecture")
    SPECIFICATION_ARCHITECTURE("specification-architecture");
    private final String value;

    Leancategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Leancategory fromValue(String v) {
        for (Leancategory c: Leancategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
