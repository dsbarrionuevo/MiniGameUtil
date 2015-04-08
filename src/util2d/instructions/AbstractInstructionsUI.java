package util2d.instructions;

import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public abstract class AbstractInstructionsUI extends JDialog {

    protected Instructions instructions;

    public AbstractInstructionsUI(Frame frame, boolean bln){
        super(frame, bln);
    }
    
    public void setInstruction(Instructions instructions) {
        this.instructions = instructions;
    }

    public Instructions getInstruction() {
        return this.instructions;
    }
}
