package panels;

import javax.swing.*;
import java.awt.*;

public class LabelFor extends JLabel {

    public LabelFor(String name) {
        setText(name);
        Font LABEL_FONTS = new Font("Tahoma", Font.PLAIN, 20);
        setFont(LABEL_FONTS);
        setHorizontalAlignment(CENTER);
        setFocusable(false);
    }

}
