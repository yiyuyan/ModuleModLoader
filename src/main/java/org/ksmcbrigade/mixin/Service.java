package org.ksmcbrigade.mixin;

import org.spongepowered.asm.launch.platform.container.IContainerHandle;
import org.spongepowered.asm.logging.ILogger;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.service.*;
import org.spongepowered.asm.util.ReEntranceLock;

import java.io.InputStream;
import java.util.Collection;

public class Service implements IMixinService {
    @Override
    public String getName() {
        return "ModuleModLoaderMixin";
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void prepare() {

    }

    @Override
    public MixinEnvironment.Phase getInitialPhase() {
        return null;
    }

    @Override
    public void offer(IMixinInternal internal) {

    }

    @Override
    public void init() {

    }

    @Override
    public void beginPhase() {

    }

    @Override
    public void checkEnv(Object bootSource) {

    }

    @Override
    public ReEntranceLock getReEntranceLock() {
        return null;
    }

    @Override
    public IClassProvider getClassProvider() {
        return null;
    }

    @Override
    public IClassBytecodeProvider getBytecodeProvider() {
        return null;
    }

    @Override
    public ITransformerProvider getTransformerProvider() {
        return null;
    }

    @Override
    public IClassTracker getClassTracker() {
        return null;
    }

    @Override
    public IMixinAuditTrail getAuditTrail() {
        return null;
    }

    @Override
    public Collection<String> getPlatformAgents() {
        return null;
    }

    @Override
    public IContainerHandle getPrimaryContainer() {
        return null;
    }

    @Override
    public Collection<IContainerHandle> getMixinContainers() {
        return null;
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        return null;
    }

    @Override
    public String getSideName() {
        return null;
    }

    @Override
    public MixinEnvironment.CompatibilityLevel getMinCompatibilityLevel() {
        return null;
    }

    @Override
    public MixinEnvironment.CompatibilityLevel getMaxCompatibilityLevel() {
        return null;
    }

    @Override
    public ILogger getLogger(String name) {
        return null;
    }
}
