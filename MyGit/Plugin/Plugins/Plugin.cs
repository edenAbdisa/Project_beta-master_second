﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Plugins
{
    public interface Plugin
    {

        void run();
        String PluginName();
    }
}
