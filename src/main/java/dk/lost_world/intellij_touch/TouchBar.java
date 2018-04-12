package dk.lost_world.intellij_touch;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.common.Color;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;
import com.thizzer.jtouchbar.item.view.TouchBarTextField;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;

public class TouchBar {

    protected JTouchBar jTouchBar;

    protected Project project;

    public static TouchBar getInstance(Project project) {
        return ServiceManager.getService(project, TouchBar.class);
    }

    public TouchBar(Project project) {
        this.project = project;
        IconFontSwing.register(FontAwesome.getIconFont());

        jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier("intellij-touch");
        jTouchBar.show(WindowManager.getInstance().getFrame(this.project));
    }

    public void addItem(TouchBarItem touchBarItem) {
        this.jTouchBar.addItem(touchBarItem);
        jTouchBar.show(WindowManager.getInstance().getFrame(this.project));
    }
}
