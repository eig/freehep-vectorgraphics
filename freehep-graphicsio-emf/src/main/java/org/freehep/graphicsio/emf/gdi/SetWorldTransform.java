// Copyright 2002, FreeHEP.
package org.freehep.graphicsio.emf.gdi;

import java.awt.geom.AffineTransform;
import java.io.IOException;

import org.freehep.graphicsio.emf.EMFInputStream;
import org.freehep.graphicsio.emf.EMFOutputStream;
import org.freehep.graphicsio.emf.EMFTag;

/**
 * SetWorldTransform TAG.
 * 
 * @author Mark Donszelmann
 * @version $Id: freehep-graphicsio-emf/src/main/java/org/freehep/graphicsio/emf/gdi/SetWorldTransform.java 63c8d910ece7 2007/01/20 15:30:50 duns $
 */
public class SetWorldTransform extends EMFTag {

    private AffineTransform transform;

    public SetWorldTransform() {
        super(35, 1);
    }

    public SetWorldTransform(AffineTransform transform) {
        this();
        this.transform = transform;
    }

    public EMFTag read(int tagID, EMFInputStream emf, int len)
            throws IOException {

        SetWorldTransform tag = new SetWorldTransform(emf.readXFORM());
        return tag;
    }

    public void write(int tagID, EMFOutputStream emf) throws IOException {
        emf.writeXFORM(transform);
    }

    public String toString() {
        return super.toString() + "\n" + "  transform: " + transform;
    }

    public AffineTransform getTransform() {
        return transform;
    }
}
