/*
 *  Copyright (C) 2010-2022 JPEXS, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */
package com.jpexs.decompiler.graph;

import com.jpexs.decompiler.flash.BaseLocalData;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author JPEXS
 */
public interface GraphSourceItem extends Serializable, Cloneable {

    public void translate(BaseLocalData localData, TranslateStack stack, List<GraphTargetItem> output, int staticOperation, String path) throws InterruptedException;

    public int getStackPopCount(BaseLocalData localData, TranslateStack stack);

    public int getStackPushCount(BaseLocalData localData, TranslateStack stack);

    public long getFileOffset();

    public boolean isJump();

    public boolean isBranch();

    public boolean isExit();

    public long getAddress();

    public long getLineOffset();

    public boolean ignoredLoops();

    public List<Integer> getBranches(GraphSource code);

    public boolean isIgnored();

    public void setIgnored(boolean ignored, int pos);

    public boolean isDeobfuscatePop();

    public int getLine();

    public String getFile();

    public abstract int getBytesLength();

    /**
     * Gets virtual address. A virtual adress can be used for storing original
     * address before applying deobfuscation
     *
     * @return
     */
    public long getVirtualAddress();

    /**
     * Sets virtual address. A virtual adress can be used for storing original
     * address before applying deobfuscation
     *
     * @param virtualAddress
     */
    public void setVirtualAddress(long virtualAddress);
}
