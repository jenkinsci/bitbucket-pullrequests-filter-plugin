/*
 * The MIT License
 *
 * Copyright (c) 2023, Gabriel Einsdorf.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.bitbucket.pullrequests.filter.filters.branch;

import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketPullRequest;
import jenkins.scm.api.SCMHead;
import org.jenkinsci.plugins.bitbucket.pullrequests.filter.filters.AbstractPullRequestFilter;
import org.jenkinsci.plugins.bitbucket.pullrequests.filter.utils.filters.StringFilter;

/**
 * A {@link SCMHead} filter to only include pull request that originate from specific branches.
 * 
 * @since 0.2.0
 *
 */
public class PullRequestSourceBranchMatchesFilter extends AbstractPullRequestFilter<String> {

    /**
     * {@inheritDoc}
     */
	public PullRequestSourceBranchMatchesFilter(StringFilter filter) {
		super(filter);
	}

    /**
     * {@inheritDoc}
     */
	@Override
	protected String getData(BitbucketPullRequest pullRequest) {
		return pullRequest.getSource().getBranch().getName();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	protected String getMessage(BitbucketPullRequest pullRequest) {
        return "The pull request does not originate from an allowlisted branch: '"+ pullRequest.getSource().getBranch().getName() + "' Skipped.";
	}

}
