/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jenkinsci.plugins.workspacelayering;

import hudson.Extension;
import hudson.FileSystemProvisioner;
import hudson.model.Descriptor;
import hudson.model.Node;
import hudson.model.Slave;
import hudson.slaves.ComputerLauncher;
import hudson.slaves.NodeProperty;
import hudson.slaves.RetentionStrategy;
import java.io.IOException;
import java.util.List;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 *
 * @author matepeter
 */
public final class WorkspaceLayeringSlave extends Slave{

    @Override
    public FileSystemProvisioner getFileSystemProvisioner() {
        return super.getFileSystemProvisioner(); //To change body of generated methods, choose Tools | Templates.
    }

    @DataBoundConstructor
    public WorkspaceLayeringSlave(String name, String nodeDescription, String remoteFS, String numExecutors, Mode mode, String labelString, ComputerLauncher launcher, RetentionStrategy retentionStrategy, List<? extends NodeProperty<?>> nodeProperties) throws Descriptor.FormException, IOException {
        super(name, nodeDescription, remoteFS, numExecutors, mode, labelString, launcher, retentionStrategy, nodeProperties);
    }

    @Extension
    public static final class DescriptorImpl extends SlaveDescriptor {

        public DescriptorImpl() {
            load();
        }

        public String getDisplayName() {
            return "Workspace overlay Slave";
        }

        @Override
        public boolean isInstantiable() {
            return true;
        }

    }
}
