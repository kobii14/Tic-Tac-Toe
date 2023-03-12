/**
 * a factory for different kinds of renderers
 */
public class RendererFactory {
    /**
     * a function that builds different kinds of renderers by a given string
     * @param str a name that represents a renderer
     * @return the specific type of the renderer if there is one, null otherwise
     */
    Renderer buildRenderer(String str)
    {
        switch (str)
        {
            case "console":
                return new ConsoleRenderer();
            case "none":
                return new VoidRenderer();
            default:
                return null;
        }
    }
}
