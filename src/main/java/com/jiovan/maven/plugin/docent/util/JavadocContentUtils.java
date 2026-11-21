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

package com.jiovan.maven.plugin.docent.util;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * Utilities for javadoc content
 *
 * @author David Hsing
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class JavadocContentUtils {
    private static final String A_BLANK = "<a href=\"%s\" target=\"_blank\">%s</a>";    // $NON-NLS-1$
    private static final String DT_DD = "<dt>%s</dt><dd>%s</dd>";    // $NON-NLS-1$
    private static final String SPAN_SIMPLE = "<span class=\"simpleTagLabel\">%s</span>";    // $NON-NLS-1$
    private static final String TABLE = "<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\">%s</table>";    // $NON-NLS-1$
    private static final String TR_TD = "<tr><td>%s</td></tr>";    // $NON-NLS-1$

    /**
     * Matches a double-quoted, single-quoted or back-quoted argument as a whole (spaces allowed inside),
     * otherwise falls back to a whitespace-delimited argument
     */
    private static final Pattern ARGS_PATTERN = Pattern.compile("\"([^\"]*)\"|'([^']*)'|`([^`]*)`|(\\S+)");    // $NON-NLS-1$

    /**
     * Splits the tag content into arguments, keeping a quoted argument as one argument and
     * stripping its wrapping quotes, e.g. {@code "Example Dtdd" "Dtdd Content"} becomes
     * {@code ["Example Dtdd", "Dtdd Content"]}
     *
     * @param text the tag content
     *
     * @return the arguments, never {@code null}
     */
    @Nonnull
    public static String[] argsToArray(@Nullable String text) {
        if (StringUtils.isBlank(text)) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        List<String> args = new ArrayList<>();
        Matcher matcher = ARGS_PATTERN.matcher(text);
        while (matcher.find()) {
            // only one of the groups is not null, so keep a quoted-but-empty argument as empty string
            String arg = (matcher.group(1) != null) ? matcher.group(1)
                    : (matcher.group(2) != null) ? matcher.group(2)
                    : (matcher.group(3) != null) ? matcher.group(3)
                    : matcher.group(4);
            args.add(StringUtils.defaultString(arg));
        }
        return args.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    @Nullable
    public static String aOpeningBlank(@Nullable String href) {
        return aOpeningBlank(href, null);
    }

    @Nullable
    public static String aOpeningBlank(@Nullable String href, @Nullable String content) {
        return StringUtils.isBlank(href) ? null : String.format(A_BLANK, HtmlTreeUtils.encodeUrl(href), StringUtils.defaultIfBlank(content, href));
    }

    @Nullable
    public static String dtDd(@Nullable String dtTitle, @Nullable String ddContent) {
        return StringUtils.isAllBlank(dtTitle, ddContent) ? null : String.format(DT_DD, StringUtils.defaultString(dtTitle), StringUtils.defaultString(ddContent));
    }

    @Nullable
    public static String dtSpanDdTable(@Nullable String dtTitle, @Nullable String tabSubset) {
        if (StringUtils.isAllBlank(dtTitle, tabSubset)) {
            return null;
        }
        return dtDd(String.format(SPAN_SIMPLE, StringUtils.defaultString(dtTitle)), String.format(TABLE, StringUtils.defaultString(tabSubset)));
    }

    @Nullable
    public static String trTdAOpeningBlank(@Nullable String href, @Nullable String text) {
        String a = aOpeningBlank(href, text);
        return StringUtils.isBlank(a) ? null : String.format(TR_TD, a);
    }

    public static String unquote(@Nullable String text) {
        return RegExUtils.replaceAll(text, "^['\"`]|['\"`]$", StringUtils.EMPTY);    // $NON-NLS-1$
    }
}
