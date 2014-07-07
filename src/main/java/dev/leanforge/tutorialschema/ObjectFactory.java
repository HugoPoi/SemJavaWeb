//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.07.07 à 10:25:25 PM CEST 
//


package dev.leanforge.tutorialschema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dev.leanforge.tutorialschema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dev.leanforge.tutorialschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Tutorial }
     * 
     */
    public Tutorial createTutorial() {
        return new Tutorial();
    }

    /**
     * Create an instance of {@link Tutorial.Content }
     * 
     */
    public Tutorial.Content createTutorialContent() {
        return new Tutorial.Content();
    }

    /**
     * Create an instance of {@link Tutorial.Content.Step }
     * 
     */
    public Tutorial.Content.Step createTutorialContentStep() {
        return new Tutorial.Content.Step();
    }

    /**
     * Create an instance of {@link Tutorial.Content.Step.Substep }
     * 
     */
    public Tutorial.Content.Step.Substep createTutorialContentStepSubstep() {
        return new Tutorial.Content.Step.Substep();
    }

    /**
     * Create an instance of {@link Tutorial.Meta }
     * 
     */
    public Tutorial.Meta createTutorialMeta() {
        return new Tutorial.Meta();
    }

    /**
     * Create an instance of {@link Tutorial.Meta.Software }
     * 
     */
    public Tutorial.Meta.Software createTutorialMetaSoftware() {
        return new Tutorial.Meta.Software();
    }

    /**
     * Create an instance of {@link Img }
     * 
     */
    public Img createImg() {
        return new Img();
    }

    /**
     * Create an instance of {@link Tutorial.Content.Step.Substep.Video }
     * 
     */
    public Tutorial.Content.Step.Substep.Video createTutorialContentStepSubstepVideo() {
        return new Tutorial.Content.Step.Substep.Video();
    }

    /**
     * Create an instance of {@link Tutorial.Content.Step.Substep.Btn }
     * 
     */
    public Tutorial.Content.Step.Substep.Btn createTutorialContentStepSubstepBtn() {
        return new Tutorial.Content.Step.Substep.Btn();
    }

    /**
     * Create an instance of {@link Tutorial.Content.Step.Substep.Multiimg }
     * 
     */
    public Tutorial.Content.Step.Substep.Multiimg createTutorialContentStepSubstepMultiimg() {
        return new Tutorial.Content.Step.Substep.Multiimg();
    }

    /**
     * Create an instance of {@link Tutorial.Content.Step.Substep.Slider }
     * 
     */
    public Tutorial.Content.Step.Substep.Slider createTutorialContentStepSubstepSlider() {
        return new Tutorial.Content.Step.Substep.Slider();
    }

    /**
     * Create an instance of {@link Tutorial.Meta.Languages }
     * 
     */
    public Tutorial.Meta.Languages createTutorialMetaLanguages() {
        return new Tutorial.Meta.Languages();
    }

    /**
     * Create an instance of {@link Tutorial.Meta.Categories }
     * 
     */
    public Tutorial.Meta.Categories createTutorialMetaCategories() {
        return new Tutorial.Meta.Categories();
    }

    /**
     * Create an instance of {@link Tutorial.Meta.Software.Website }
     * 
     */
    public Tutorial.Meta.Software.Website createTutorialMetaSoftwareWebsite() {
        return new Tutorial.Meta.Software.Website();
    }

}
