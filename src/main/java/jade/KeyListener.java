package jade;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

import org.lwjgl.glfw.GLFWKeyCallbackI;

public class KeyListener {
	private static KeyListener instance;
	private boolean keyPressed[] = new boolean[350];

	private KeyListener() {

	}

	public static KeyListener get() {
		if (KeyListener.instance == null) {
			KeyListener.instance = new KeyListener();
		}

		return KeyListener.instance;
	}

	// ...

	private static class KeyCallback implements GLFWKeyCallbackI {
		public void invoke(long window, int key, int scancode, int action, int mods) {
			keyCallback(window, key, scancode, action, mods);
		}
	}

	public static GLFWKeyCallbackI getKeyCallback() {
		return new KeyCallback();
	}

	// ...

	public static void keyCallback(long window, int key, int scancode, int action, int mods) {
		if (action == GLFW_PRESS) {
			get().keyPressed[key] = true;
		} else if (action == GLFW_RELEASE) {
			get().keyPressed[key] = false;
		}
	}

	public static boolean isKeyPressed(int keyCode) {
		return get().keyPressed[keyCode];
	}
}
