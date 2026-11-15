/*
 * Copyright (c) 2026 Jiovan Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jiovan.maven.plugin.docent.taglet;


import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import jakarta.annotation.Nonnull;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import com.jiovan.maven.plugin.docent.util.JavadocContentUtils;


/**
 * A block taglet that representing {@code `@dtdd`} tag
 *
 * <pre><code>
 *     &#64;dtdd "Dtdd Title" "Dtdd Content"
 * </code></pre>
 * represents
 * <pre><code>
 *     &lt;dt&gt;
 *         Dtdd Title
 *     &lt;/dt&gt;
 *     &lt;dd&gt;
 *         Dtdd Content
 *     &lt;/dd&gt;
 * </code></pre>
 *
 * @author David Hsing
 *
 * @dtdd "Dtdd Title" "Dtdd Content"
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue", "JavadocDeclaration"})
public class DtddTaglet extends AbstractBlockTaglet {
    private static final String TAG_NAME = "dtdd";    // $NON-NLS-1$

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return TAG_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("DuplicatedCode")
    public String toString(@Nonnull List<? extends DocTree> tags, @Nonnull Element element) {
        if (tags.isEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (DocTree tag : tags) {
            if (!(tag instanceof UnknownBlockTagTree tree)) {
                continue;
            }
            // keep a quoted argument (spaces allowed inside) as a whole, e.g. "Example Dtdd" "Dtdd Content"
            String[] args = JavadocContentUtils.argsToArray(tree.getContent().toString());
            String title = JavadocContentUtils.unquote(ArrayUtils.get(args, 0));
            String content = JavadocContentUtils.unquote(ArrayUtils.get(args, 1));
            String dtDd = JavadocContentUtils.dtDd(title, content);
            if (StringUtils.isNotBlank(dtDd)) {
                result.add(dtDd);
            }
        }
        return result.isEmpty() ? null : StringUtils.join(result, StringUtils.EMPTY);
    }
}
