package idea.plugin.jmeter.run;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JmeterRunConfigurationForm {
    private TextFieldWithBrowseButton testFile;
    private JPanel rootPanel;

    public JmeterRunConfigurationForm(final Project project) {
        testFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VirtualFile file = FileChooser.chooseFile(project, FileChooserDescriptorFactory.createSingleLocalFileDescriptor());
                if (file != null) {
                    testFile.setText(file.getPath());
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getTestFile() {
        return testFile.getText();
    }

    public void setTestFile(String testFile) {
        this.testFile.setText(testFile);
    }
}
