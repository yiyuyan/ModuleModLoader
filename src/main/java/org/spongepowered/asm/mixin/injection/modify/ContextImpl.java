package org.spongepowered.asm.mixin.injection.modify;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;

public class ContextImpl extends LocalVariableDiscriminator.Context {
    public ContextImpl(InjectionInfo info, Type returnType, boolean argsOnly, Target target, AbstractInsnNode node) {
        super(info, returnType, argsOnly, target, node);
    }
}
