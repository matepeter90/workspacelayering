package org.jenkinsci.plugins.workspacelayering;
import hudson.Extension;
import hudson.model.Descriptor;
import hudson.tasks.BuildWrapper;
import org.kohsuke.stapler.DataBoundConstructor;

public class WorkspaceLayering extends BuildWrapper {

    private final boolean workspaceLayering;

    @DataBoundConstructor
    public WorkspaceLayering(boolean workspaceLayering) {
        this.workspaceLayering = workspaceLayering;
    }

    /**
     * We'll use this from the <tt>config.jelly</tt>.
     */
    public boolean getWorkspaceLayering() {
        return workspaceLayering;
    }
    
    @Extension
    public static final class DescriptorImpl extends Descriptor<BuildWrapper> {

            /**
             * This human readable name is used in the configuration screen.
             */
            public String getDisplayName() {
                    // TODO localization
                    return "Use workspace layering";
            }

    }
}

