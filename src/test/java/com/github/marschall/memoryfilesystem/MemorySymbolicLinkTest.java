package com.github.marschall.memoryfilesystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Before;
import org.junit.Test;

public class MemorySymbolicLinkTest {

  private MemorySymbolicLink memoryFile;

  @Before
  public void setUp() {
    this.memoryFile = new MemorySymbolicLink("", null);
  }

  @Test
  public void testCheckMethods() throws IOException {
    BasicFileAttributes attributes = this.memoryFile.getBasicFileAttributeView().readAttributes();

    assertFalse(attributes.isRegularFile());

    assertFalse(attributes.isDirectory());
    assertFalse(attributes.isOther());
    assertTrue(attributes.isSymbolicLink());

    assertEquals(-1L, attributes.size());

    assertNotNull(attributes.fileKey());
  }

}
