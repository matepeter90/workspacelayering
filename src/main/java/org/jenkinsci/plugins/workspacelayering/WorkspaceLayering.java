package org.jenkinsci.plugins.workspacelayering;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Descriptor;
import hudson.tasks.BuildWrapper;
import java.io.IOException;
import org.kohsuke.stapler.DataBoundConstructor;

public class WorkspaceLayering extends BuildWrapper {

    private final boolean workspaceLayering;

    @DataBoundConstructor
    public WorkspaceLayering(boolean workspaceLayering) {
        this.workspaceLayering = workspaceLayering;
    }

    public boolean getWorkspaceLayering() {
        return workspaceLayering;
    }
    
    @Override
    public void preCheckout(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException{
        Launcher a = launcher;
    }
    
    @Override
     public Environment setUp(AbstractBuild build, Launcher launcher,
            BuildListener listener) throws IOException, InterruptedException {
            return new LayeredEnvironment();
     }
     
     
    @Extension
    public static final class DescriptorImpl extends Descriptor<BuildWrapper> {

            /**
             * This human readable name is used in the configuration screen.
             */
            public String getDisplayName() {
                    return "Use workspace layering";
            }

    }

    private class LayeredEnvironment extends Environment {

        @Override
        public boolean tearDown(AbstractBuild build, BuildListener listener) throws IOException, InterruptedException {
            //remove layer
            return super.tearDown(build, listener);
        }
    }
}

