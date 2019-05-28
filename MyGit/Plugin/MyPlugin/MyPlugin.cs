using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyPlugin;
using Plugins;
using System.Windows.Forms;
namespace MyPlugin
{
    public class MyPlugin : Plugin
    {
        public string PluginName()
        {
            return "MyPlugin";
        }

        public void run()
        {
            MessageBox.Show("You have successfully uploaded the plugin.");
        }
    }
}
