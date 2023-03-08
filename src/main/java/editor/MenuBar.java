package editor;

import java.awt.Event;

import imgui.ImGui;
import observers.EventSystem;

public class MenuBar {

	public void imgui() {
		ImGui.beginMenuBar();

		if (ImGui.beginMenu("File")) {
			if (ImGui.menuItem("Save", "Ctrl+S")) {
				EventSystem.notify(null, new Event(EventType.SaveLevel));
			}

			if (ImGui.menuItem("Load", "Ctrl+O")) {
				EventSystem.notify(null, new Event(EventType.LoadLevel));
			}

			ImGui.endMenu();
		}

		ImGui.endMenuBar();
	}
}