/*
   (C) 2018 Raryel C. Souza
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.wmj.jautosub;

import org.wmj.jautosub.util.StreamGobbler;
import org.wmj.jautosub.util.SRTParser;
import org.wmj.jautosub.util.Util;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;
import org.wmj.jautosub.gui.ButtonTabComponent;

public class MainWindow extends javax.swing.JFrame implements HyperlinkListener
{

    private Process procAutosub;
    /**
     * Creates new form MainWindow
     */
    public MainWindow()
    {
        initComponents();
        // for jtaStatus auto scrolling when more text is appended
        ((DefaultCaret) jtaStatus.getCaret()).setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
        jpbConversion.setVisible(false);
        pack();
        addWindowListener(new WindowAdapter()
        {
            //clear tmp files before leaving
            @Override
            public void windowClosing(WindowEvent e)
            {
                procAutosub.destroyForcibly();
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
        extFilter = new FileNameExtensionFilter("Audio/Video Files", "mp3", "wma", "wav", "m4a", "mp4", "flv", "mpg", "mov", "3gp", "avi");

        pOutputFolder = Paths.get(System.getProperty("user.home")).resolve("JAutosub");
        jtfOutputFolder.setText(pOutputFolder.toFile().toString());

        jfc.setCurrentDirectory(Paths.get(System.getProperty("user.home")).toFile());
        jfc.setFileFilter(extFilter);
        jfc.setMultiSelectionEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jfc = new javax.swing.JFileChooser();
        jpMainSouth = new javax.swing.JPanel();
        jspStatus = new javax.swing.JScrollPane();
        jtaStatus = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jpbConversion = new javax.swing.JProgressBar();
        jpMainNorth = new javax.swing.JPanel();
        jpNorthCenter = new javax.swing.JPanel();
        jtfOutputFolder = new javax.swing.JTextField();
        jpListFiles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlFilesSelected = new javax.swing.JList<>();
        jbSelectOutputFolder = new javax.swing.JButton();
        jbSelectAudioFile = new javax.swing.JButton();
        jpNorthSouth = new javax.swing.JPanel();
        jpControlButtons = new javax.swing.JPanel();
        jbConvert = new javax.swing.JButton();
        jbOpenOutputFolder = new javax.swing.JButton();
        jpLanguage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbLanguage = new javax.swing.JComboBox<>();
        jpMainCenter = new javax.swing.JPanel();
        jtpOutput = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jbCopy = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jbLicense = new javax.swing.JMenuItem();
        jbAboutAutosub = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JAutosub - v1.1 (Powered by Autosub)");

        jpMainSouth.setBorder(javax.swing.BorderFactory.createTitledBorder("Conversion Progress:"));
        jpMainSouth.setPreferredSize(new java.awt.Dimension(620, 100));
        jpMainSouth.setLayout(new java.awt.BorderLayout());

        jtaStatus.setEditable(false);
        jtaStatus.setColumns(20);
        jtaStatus.setRows(5);
        jspStatus.setViewportView(jtaStatus);

        jpMainSouth.add(jspStatus, java.awt.BorderLayout.CENTER);

        jpbConversion.setIndeterminate(true);
        jpbConversion.setPreferredSize(new java.awt.Dimension(600, 12));
        jPanel2.add(jpbConversion);

        jpMainSouth.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jpMainSouth, java.awt.BorderLayout.SOUTH);

        jpMainNorth.setPreferredSize(new java.awt.Dimension(12, 330));
        jpMainNorth.setLayout(new java.awt.BorderLayout());

        jtfOutputFolder.setEditable(false);
        jtfOutputFolder.setPreferredSize(new java.awt.Dimension(300, 24));
        jtfOutputFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jtfOutputFolderActionPerformed(evt);
            }
        });

        jpListFiles.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Files to Convert"));

        jScrollPane1.setViewportView(jlFilesSelected);

        javax.swing.GroupLayout jpListFilesLayout = new javax.swing.GroupLayout(jpListFiles);
        jpListFiles.setLayout(jpListFilesLayout);
        jpListFilesLayout.setHorizontalGroup(
            jpListFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpListFilesLayout.setVerticalGroup(
            jpListFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jbSelectOutputFolder.setText("Select Output Folder");
        jbSelectOutputFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbSelectOutputFolderActionPerformed(evt);
            }
        });

        jbSelectAudioFile.setText("Select Audio/Video File(s)");
        jbSelectAudioFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbSelectAudioFileActionPerformed(evt);
            }
        });

        jbConvert.setText("Convert");
        jbConvert.setEnabled(false);
        jbConvert.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbConvertActionPerformed(evt);
            }
        });
        jpControlButtons.add(jbConvert);

        jbOpenOutputFolder.setText("Open Output Folder");
        jbOpenOutputFolder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbOpenOutputFolderActionPerformed(evt);
            }
        });
        jpControlButtons.add(jbOpenOutputFolder);

        jLabel1.setText("Audio Language:");
        jpLanguage.add(jLabel1);

        jcbLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "en - English", "af - Afrikaans", "ar - Arabic", "az - Azerbaijani", "be - Belarusian", "bg - Bulgarian", "bn - Bengali", "bs - Bosnian", "ca - Catalan", "ceb -Cebuano", "cs - Czech", "cy - Welsh", "da - Danish", "de - German", "el - Greek", "eo - Esperanto", "es - Spanish", "et - Estonian", "eu - Basque", "fa - Persian", "fi - Finnish", "fr - French", "ga - Irish", "gl - Galician", "gu -Gujarati", "ha - Hausa", "hi - Hindi", "hmn - Hmong", "hr - Croatian", "ht - Haitian Creole", "hu - Hungarian", "hy - Armenian", "id - Indonesian", "ig - Igbo", "is - Icelandic", "it - Italian", "iw - Hebrew", "ja - Japanese", "jw - Javanese", "ka - Georgian", "kk - Kazakh", "km - Khmer", "kn - Kannada", "ko - Korean", "la - Latin", "lo - Lao", "lt - Lithuanian", "lv - Latvian", "mg - Malagasy", "mi - Maori", "mk - Macedonian", "ml - Malayalam", "mn - Mongolian", "mr - Marathi", "ms - Malay", "mt - Maltese", "my - Myanmar (Burmese)", "ne - Nepali", "nl - Dutch", "no - Norwegian", "ny - Chichewa", "pa - Punjabi", "pl - Polish", "pt - Portuguese", "ro - Romanian", "ru - Russian", "si - Sinhala", "sk - Slovak", "sl - Slovenian", "so - Somali", "sq - Albanian", "sr - Serbian", "st - Sesotho", "su - Sudanese", "sv - Swedish", "sw - Swahili", "ta - Tamil", "te - Telugu", "tg - Tajik", "th - Thai", "tl - Filipino", "tr - Turkish", "uk - Ukrainian", "ur - Urdu", "uz - Uzbek", "vi - Vietnamese", "yi - Yiddish", "yo - Yoruba", "zh-CN - Chinese (Simplified)", "zh-TW - Chinese (Traditional)", "zu - Zulu" }));
        jcbLanguage.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jcbLanguageActionPerformed(evt);
            }
        });
        jpLanguage.add(jcbLanguage);

        javax.swing.GroupLayout jpNorthSouthLayout = new javax.swing.GroupLayout(jpNorthSouth);
        jpNorthSouth.setLayout(jpNorthSouthLayout);
        jpNorthSouthLayout.setHorizontalGroup(
            jpNorthSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNorthSouthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNorthSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpControlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpLanguage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpNorthSouthLayout.setVerticalGroup(
            jpNorthSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNorthSouthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpNorthCenterLayout = new javax.swing.GroupLayout(jpNorthCenter);
        jpNorthCenter.setLayout(jpNorthCenterLayout);
        jpNorthCenterLayout.setHorizontalGroup(
            jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNorthCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNorthCenterLayout.createSequentialGroup()
                        .addGroup(jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbSelectAudioFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSelectOutputFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfOutputFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(jpListFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jpNorthSouth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpNorthCenterLayout.setVerticalGroup(
            jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNorthCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSelectAudioFile)
                    .addComponent(jpListFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpNorthCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSelectOutputFolder)
                    .addComponent(jtfOutputFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpNorthSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpMainNorth.add(jpNorthCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpMainNorth, java.awt.BorderLayout.NORTH);

        jpMainCenter.setBorder(javax.swing.BorderFactory.createTitledBorder("Automatic Transcription Output"));
        jpMainCenter.setMinimumSize(new java.awt.Dimension(213, 220));
        jpMainCenter.setPreferredSize(new java.awt.Dimension(12, 200));
        jpMainCenter.setLayout(new java.awt.BorderLayout());

        jtpOutput.setName(""); // NOI18N
        jpMainCenter.add(jtpOutput, java.awt.BorderLayout.CENTER);

        jbCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/wmj/jautosub/gui/copy.png"))); // NOI18N
        jbCopy.setText("Copy Text to Clipboard");
        jbCopy.setEnabled(false);
        jbCopy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbCopyActionPerformed(evt);
            }
        });
        jPanel5.add(jbCopy);

        jpMainCenter.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jpMainCenter, java.awt.BorderLayout.CENTER);

        jMenu2.setText("About");

        jbLicense.setText("License");
        jbLicense.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbLicenseActionPerformed(evt);
            }
        });
        jMenu2.add(jbLicense);

        jbAboutAutosub.setText("About JAutosub");
        jbAboutAutosub.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbAboutAutosubActionPerformed(evt);
            }
        });
        jMenu2.add(jbAboutAutosub);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showTabOutputText(String fileName, String text)
    {
        JScrollPane jsp;
        JTextArea jta;
        int indexCurrentTab;

        if (!text.isEmpty())
        {

            jta = new JTextArea(text);
            jta.setLineWrap(true);
            jta.setWrapStyleWord(true);
            jta.setFont(jta.getFont().deriveFont(16f));

            jsp = new JScrollPane(jta);

            indexCurrentTab = jtpOutput.getTabCount();
            jtpOutput.addTab(fileName, jsp);
            jtpOutput.setTabComponentAt(indexCurrentTab, new ButtonTabComponent(jtpOutput));
            jbCopy.setEnabled(true);

            listJTA.add(jta);
        }
    }

    private void jbCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbCopyActionPerformed
    {//GEN-HEADEREND:event_jbCopyActionPerformed
        int indexSelectedTab;
        StringSelection objStrSelection;
        String text2Copy;
        Clipboard clipboard;

        indexSelectedTab = jtpOutput.getSelectedIndex();
        text2Copy = listJTA.get(indexSelectedTab).getText();
        objStrSelection = new StringSelection(text2Copy);

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(objStrSelection, objStrSelection);
    }//GEN-LAST:event_jbCopyActionPerformed

    private void jcbLanguageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jcbLanguageActionPerformed
    {//GEN-HEADEREND:event_jcbLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbLanguageActionPerformed

    private void jbOpenOutputFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbOpenOutputFolderActionPerformed
    {//GEN-HEADEREND:event_jbOpenOutputFolderActionPerformed
        //if output folder does not exist, creates it
        if (!pOutputFolder.toFile().exists())
        {
            pOutputFolder.toFile().mkdirs();
        }
        try
        {
            Desktop.getDesktop().open(pOutputFolder.toFile());
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this, "Error to open output folder: \n" + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbOpenOutputFolderActionPerformed

    private void jbConvertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbConvertActionPerformed
    {//GEN-HEADEREND:event_jbConvertActionPerformed
        if (Util.netIsAvailable())
        {
            jbConvert.setEnabled(false);
            jpbConversion.setVisible(true);

            //clears the status text area
            jtaStatus.setText("");
            Thread tConversion = new Thread()
            {
                @Override
                public void run()
                {
                    int processExit, indexSeparatorDash;
                    File outputFileSRT, outputFileTXT;
                    boolean haveConversionError;
                    String inputFileName, outputFileName, cmdPart1, cmdPart2, cmd, langSelected, strTXT, langCode;
                    Process procAutosub;

                    //extract the language code from the selected language string
                    langSelected = (String) jcbLanguage.getSelectedItem();
                    indexSeparatorDash = langSelected.lastIndexOf("-");
                    langCode = langSelected.substring(0, indexSeparatorDash);
                    cmdPart1 = pAutosub.resolve("autosub_app.exe").toString() + " -S " + langCode + " -D " + langCode + " ";

                    haveConversionError = false;
                    for (File f : arraySelectedFiles)
                    {
                        try
                        {
                            inputFileName = Util.getFileNameWithoutExtension(f);
                            outputFileName = inputFileName + ".srt";
                            outputFileSRT = pOutputFolder.resolve(outputFileName).toFile();
                            outputFileTXT = pOutputFolder.resolve(inputFileName + ".txt").toFile();

                            //merges the command parts with the input and output file
                            cmdPart2 = " -o " + "\"" + outputFileSRT.toString() + "\"";
                            cmd = cmdPart1 + "\"" + f.toString() + "\"" + cmdPart2;

                            System.out.println(cmd);
                            //if the output folder does not exist, creates it
                            if (!pOutputFolder.toFile().exists())
                            {
                                pOutputFolder.toFile().mkdirs();
                            }

                            //if there is a file with the same name of the output folder, delete it by default
                            if (outputFileSRT.exists())
                            {
                                outputFileSRT.delete();
                            }
                            if (outputFileTXT.exists())
                            {
                                outputFileTXT.delete();
                            }

                            procAutosub = Runtime.getRuntime().exec(cmd, null, pAutosub.toFile());
                            
                            //threads to collect process output
                            StreamGobbler errorGobbler = new StreamGobbler(procAutosub.getErrorStream(), "ERROR", jtaStatus);
                            StreamGobbler outputGobbler = new StreamGobbler(procAutosub.getInputStream(), "OUTPUT", jtaStatus);

                            //start auxiliary process output reading threads
                            errorGobbler.start();
                            outputGobbler.start();

                            processExit = procAutosub.waitFor();
                            //if the output file does not exist or the process returned a value
                            //different than 0, an error occured
                            if (!outputFileSRT.exists() || processExit != 0)
                            {
                                haveConversionError = true;
                                JOptionPane.showMessageDialog(null, "Error! Unable to convert file " + f.toString() + ".", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            else
                            {
                                //if conversion successful extract the text from the srt file
                                strTXT = SRTParser.extractTextFromSRT(outputFileTXT, outputFileSRT);
                                showTabOutputText(inputFileName, strTXT);
                            }
                        }
                        catch (InterruptedException | IOException ex)
                        {
                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //if none of the files on the list failed conversion
                    //shows the successful conversion message
                    if (!haveConversionError)
                    {
                        JOptionPane.showMessageDialog(null, "File(s) successfully converted!", "Conversion successful", JOptionPane.INFORMATION_MESSAGE);
                    }
                    jbConvert.setEnabled(true);
                    jpbConversion.setVisible(false);
                }

            };
            tConversion.start();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot connect to Google Speech Server. \nYou need to be connected to internet to use this app.");
        }
    }//GEN-LAST:event_jbConvertActionPerformed

    private void jbSelectAudioFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbSelectAudioFileActionPerformed
    {//GEN-HEADEREND:event_jbSelectAudioFileActionPerformed
        int output;
        String[] arrayFilePath;

        jfc.setFileFilter(extFilter);
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        output = jfc.showOpenDialog(this);
        if (output == JFileChooser.APPROVE_OPTION)
        {
            arraySelectedFiles = jfc.getSelectedFiles();
            arrayFilePath = new String[arraySelectedFiles.length];
            for (int i = 0; i < arraySelectedFiles.length; i++)
            {
                arrayFilePath[i] = arraySelectedFiles[i].toString();
            }
            jlFilesSelected.setListData(arrayFilePath);
            jbConvert.setEnabled(true);
        }
        else
        {
            if (jlFilesSelected.getModel().getSize() == 0)
            {
                jbConvert.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jbSelectAudioFileActionPerformed

    private void jbSelectOutputFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbSelectOutputFolderActionPerformed
    {//GEN-HEADEREND:event_jbSelectOutputFolderActionPerformed
        int output;
        File fSelectedFolder;

        jfc.setFileFilter(null);
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        output = jfc.showOpenDialog(this);
        if (output == JFileChooser.APPROVE_OPTION)
        {
            fSelectedFolder = jfc.getSelectedFile();
            pOutputFolder = fSelectedFolder.toPath();
            jtfOutputFolder.setText(fSelectedFolder.toString());
        }
    }//GEN-LAST:event_jbSelectOutputFolderActionPerformed

    private void jtfOutputFolderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jtfOutputFolderActionPerformed
    {//GEN-HEADEREND:event_jtfOutputFolderActionPerformed

    }//GEN-LAST:event_jtfOutputFolderActionPerformed

    private void initStyleCSS()
    {
        JLabel label = new JLabel();
        Font font = label.getFont();

        // create some css from the label's font
        StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
        style.append("font-weight:" + (font.isBold() ? "bold" : "normal") + ";");
        style.append("font-size:" + font.getSize() + "pt;");
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e)
    {
        if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
        {
            try
            {
                Desktop.getDesktop().browse(e.getURL().toURI());
            }
            catch (URISyntaxException | IOException ex)
            {
                JOptionPane.showMessageDialog(this, "Unable to open link on browser.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jbAboutAutosubActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbAboutAutosubActionPerformed
    {//GEN-HEADEREND:event_jbAboutAutosubActionPerformed
        JLabel label = new JLabel();

        // html content
        JEditorPane ep = new JEditorPane("text/html", "<html><body style=\"" + styleCSS + "\">"
                + "JAutosub is a Java GUI for Autosub intended to support audio transcription<br><br>"
                + "<a href=\"https://github.com/agermanidis/autosub\">Autosub</a> is a command-line utility for auto-generating subtitles for any video/audio file<br>"
                + "using the <a href=\"https://cloud.google.com/speech/\">Google Cloud Speech API</a> <br>"
                + "</body></html>");

        // handle link events
        ep.addHyperlinkListener(this);
        ep.setEditable(false);
        ep.setBackground(label.getBackground());

        // show
        JOptionPane.showMessageDialog(null, ep, "About JAutosub", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbAboutAutosubActionPerformed

    private void jbLicenseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jbLicenseActionPerformed
    {//GEN-HEADEREND:event_jbLicenseActionPerformed
        JLabel label = new JLabel();

        // html content
        JEditorPane ep = new JEditorPane("text/html", "<html><body style=\"" + styleCSS + "\">"
                + "<a href=\"https://www.gnu.org/licenses/gpl-3.0.html\">GPL License</a><br><br>"
                + "Copyright (C) 2018 Raryel C. Souza <raryel.costa at gmail.com><br>"
                + "This program is free software: you can redistribute it and/or modify<br>"
                + "it under the terms of the GNU General Public License as published by<br>"
                + "the Free Software Foundation, either version 3 of the License, or<br>"
                + " any later version<br>"
                + "<br>"
                + "This program is distributed in the hope that it will be useful,<br>"
                + "but WITHOUT ANY WARRANTY; without even the implied warranty of<br>"
                + "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the<br>"
                + "GNU General Public License for more details.<br>"
                + "<br>"
                + "You should have received a copy of the GNU General Public License<br>"
                + "along with this program.  If not, see <https://www.gnu.org/licenses/>."
                + "</body></html>");

        // handle link events
        ep.addHyperlinkListener(this);
        ep.setEditable(false);
        ep.setBackground(label.getBackground());

        // show
        JOptionPane.showMessageDialog(null, ep, "License", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbLicenseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainWindow().setVisible(true);
            }
        });
    }

    private StringBuffer styleCSS;
    private ArrayList<JTextArea> listJTA = new ArrayList<>();
    private Path pAutosub = Paths.get(System.getProperty("user.dir")).resolve("autosub");
    private FileNameExtensionFilter extFilter;
    private Path pOutputFolder;
    private File[] arraySelectedFiles;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jbAboutAutosub;
    private javax.swing.JButton jbConvert;
    private javax.swing.JButton jbCopy;
    private javax.swing.JMenuItem jbLicense;
    private javax.swing.JButton jbOpenOutputFolder;
    private javax.swing.JButton jbSelectAudioFile;
    private javax.swing.JButton jbSelectOutputFolder;
    private javax.swing.JComboBox<String> jcbLanguage;
    private javax.swing.JFileChooser jfc;
    private javax.swing.JList<String> jlFilesSelected;
    private javax.swing.JPanel jpControlButtons;
    private javax.swing.JPanel jpLanguage;
    private javax.swing.JPanel jpListFiles;
    private javax.swing.JPanel jpMainCenter;
    private javax.swing.JPanel jpMainNorth;
    private javax.swing.JPanel jpMainSouth;
    private javax.swing.JPanel jpNorthCenter;
    private javax.swing.JPanel jpNorthSouth;
    private javax.swing.JProgressBar jpbConversion;
    private javax.swing.JScrollPane jspStatus;
    private javax.swing.JTextArea jtaStatus;
    private javax.swing.JTextField jtfOutputFolder;
    private javax.swing.JTabbedPane jtpOutput;
    // End of variables declaration//GEN-END:variables
}
