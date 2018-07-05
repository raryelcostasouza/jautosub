JAutosub is an Windows app that can be used to generate <b>automatic transcription / automatic subtitles </b> for audio/video files  through a friendly graphical user interface. For the hard work of speech recognition it is made use of the <a href="https://cloud.google.com/speech/">Google Speech Recognition API</a>.
<br>
<br>
This app is basically a friendly Java GUI for a pre-packaged, ready to use, Windows version of <a href="https://github.com/agermanidis/autosub">Autosub 0.3.12</a>. All the hard work of processing the audio is done by Autosub.
<br>
<br>
The app by default outputs the subtitles as .srt and the transcribed audio on the user interface as well  as .txt files.
Internet connection is REQUIRED because it uses the <a href="https://cloud.google.com/speech/">Google Cloud Speech Server</a> for the job, in the same way as the <a href="https://support.google.com/youtube/answer/6373554?hl=en">Youtube Automatic Subtitles</a>. 
<br>
<br>
IMPORTANT: The <b>accuracy</b> of the result can vary a lot, depending on many factors, mainly the <b>quality/clarity</b> of the audio. Ideally the audio input should not have background noise, sound effects or music. If there is a single speaker and he speaks in a clear and slow speed seems that the recognition is much more accurate. Sometimes, under ideal conditions it is possible to get a <a href="https://medium.com/@mlockrey/youtube-s-incredible-95-accuracy-rate-on-auto-generated-captions-b059924765d5">accuracy result close to 95%</a>.
<br>
<br>

<img src="https://github.com/raryelcostasouza/JAutosub/blob/master/jautosub-screenshot.png" height="300">

<h1>For Users - Download the Windows app</h1>
v1.1 - 04/07/2018
<li><a href="https://github.com/raryelcostasouza/JAutosub/releases/download/v.1.1/JAutosub-v1.1-setup.exe">Installable Version</a></li>
<li><a href="https://github.com/raryelcostasouza/JAutosub/releases/download/v.1.1/JAutosub-v1.1-portable.zip">Portable Version</a></li>
</ul>
Changes:
<ul>
<li>Migrate to Java 10 Modular Project (smaller app package)</li>
<li>JAutosub License change from MIT to GPL v3 (Autosub is licensed under MIT License)</li>
<li>When closing the app force to end any remaining autosub subprocess</li>
</ul>

v1.0 - 29/08/2017
<ul>

<li><a href="https://github.com/raryelcostasouza/JAutosub/releases/download/v1.0/JAutosub-Setup.exe">Installable Version</a></li>
<li><a href="https://github.com/raryelcostasouza/JAutosub/releases/download/v1.0/JAutosub-Portable.zip">Portable Version</a></li>
</ul>

<h1>For Developers - Technical Details</h1>
<ul>
<li> To get autosub running on Windows followed <a href="https://github.com/agermanidis/autosub/issues/31">this instructions.</a> </li>
<li> The packaged version of Autosub contained was generated by <a href="http://www.pyinstaller.org/"> pyInstaller</a>. </li>
<li> The final <a href="https://github.com/raryelcostasouza/JAutosub/blob/master/autosub_modified.py">autosub_modified.py<a> with all the modifications needed for packaging on the pyinstaller and <a href="https://github.com/raryelcostasouza/JAutosub/blob/master/patch-autosub-0.3.12.patch"> the respective patch for the autosub 0.3.12 </a> </li>
</ul>

<h2>For Developers - How to compile/run</h2>
Requirements:
<ul>
<li><a href="https://netbeans.apache.org/download/index.html">Apache Netbeans 9 or newer</a> - </li>
<li>JDK 9 or newer</li>
</ul>

<ol>
<li>Clone/Download git repository</li>
<li>Extract and open the netbeans project</li>
<li>Run it</li>
</ol>
